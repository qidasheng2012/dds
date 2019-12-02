package com.it.controller;

import com.baomidou.mybatisplus.core.toolkit.IOUtils;
import com.it.common.controller.BaseController;
import com.it.common.result.JsonResult;
import com.it.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Slf4j
@Controller
public class FileUploadController extends BaseController {

    @Value("${file-upload-path}")
    private String fileUploadPath;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload")
    @ResponseBody
    public JsonResult upload(@RequestParam("test") MultipartFile file) {
        if (file.isEmpty()) {
            return renderError("文件不能为空");
        }
        int year = DateUtil.getYear();    //年
        int month = DateUtil.getMonth(); //月

        // 获取文件名
        String fileName = file.getOriginalFilename();
        log.info("上传的文件名为：" + fileName);

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("上传的后缀名为：" + suffixName);

        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(fileUploadPath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);

            return renderSuccess(dest.getName());
        } catch (IllegalStateException e) {
            log.error("上传失败：", e);
        } catch (IOException e) {
            log.error("上传失败：", e);
        }

        return renderError("上传失败");
    }

    //文件下载相关代码
    @RequestMapping("/download")
    public String downloadFile(HttpServletResponse response) {
        String fileName = "code2.png";
        if (fileName != null) {
            File file = new File(fileUploadPath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    log.info("success");
                } catch (Exception e) {
                    log.error("下载文件失败：", e);
                } finally {
                    IOUtils.closeQuietly(bis);

                    IOUtils.closeQuietly(fis);
                }
            }
        }
        return null;
    }

    //多文件上传
    @PostMapping("/batch/upload")
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(bytes);
                } catch (Exception e) {
                    return "You failed to upload " + i + " => " + e.getMessage();
                } finally {
                    IOUtils.closeQuietly(stream);
                }
            } else {
                return "You failed to upload " + i + " because the file was empty.";
            }
        }

        return "upload successful";
    }
}