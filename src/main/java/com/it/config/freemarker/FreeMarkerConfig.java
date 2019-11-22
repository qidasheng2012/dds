package com.it.config.freemarker;

import com.jagregory.shiro.freemarker.ShiroTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;

/**
 * Describe: FreeMarker Shiro 标签
 */
@Configuration
public class FreeMarkerConfig {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @PostConstruct
    public void setSharedVariable() {
        try {
            // 加上这句后，可以在页面上使用shiro标签
            freeMarkerConfigurer.getConfiguration().setSharedVariable("shiro", new ShiroTags());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
