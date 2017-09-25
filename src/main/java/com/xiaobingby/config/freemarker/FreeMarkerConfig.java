package com.xiaobingby.config.freemarker;

import com.jagregory.shiro.freemarker.ShiroTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Author: XiaoBingBy
 * Email: XiaoBingBy@qq.com
 * Date: 2017/9/1
 * Time: 00:00
 * Describe: FreeMarker Shiro 标签
 */
@Configuration
public class FreeMarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;

    @PostConstruct
    public void setSharedVariable() {
        try {
            configuration.setSharedVariable("shiro", new ShiroTags());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
