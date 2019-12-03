package com.it.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.common.controller.BaseController;
import com.it.common.result.JsonResult;
import com.it.common.utils.StringUtil;
import com.it.entity.Product;
import com.it.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  产品controller
 * </p>
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/toList")
    public String toList() {
        return "/product/list";
    }

    @ResponseBody
    @GetMapping("/list")
    public Map<String, Object> list(int pageNumber, int pageSize, String searchText) {
        Map<String, Object> result = new HashMap<String, Object>();
        Page<Product> page = new Page<>(pageNumber, pageSize);
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (StringUtil.isNotEmpty(searchText)) {
            queryWrapper.like("product_name", searchText);
        }

        IPage<Product> productPage = iProductService.page(page, queryWrapper);
        result.put("total", productPage.getTotal());
        result.put("rows", productPage.getRecords());
        return result;
    }

    @ResponseBody
    @PostMapping("/add")
    public JsonResult add(Product product) {
        return iProductService.save(product) ? renderSuccess("添加成功") : renderError("添加失败");
    }

    @ResponseBody
    @PutMapping("/update")
    public JsonResult updateUser(Product product) {
        return iProductService.updateById(product) ? renderSuccess("修改成功") : renderError("修改失败");
    }

    @ResponseBody
    @DeleteMapping("/delete")
    public JsonResult delete(@RequestParam(value = "ids", required = false) String ids) {
        if (StringUtil.isEmpty(ids)) {
            return renderError("请选择数据");
        }
        String[] idArr = ids.split(",");
        return iProductService.removeByIds(Arrays.asList(idArr)) ? renderSuccess("删除成功") : renderError("删除失败");
    }

}
