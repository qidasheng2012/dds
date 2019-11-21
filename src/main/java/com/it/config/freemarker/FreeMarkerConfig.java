package com.it.config.freemarker;

import com.jagregory.shiro.freemarker.ShiroTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.PostConstruct;

/**
 * Describe: FreeMarker Shiro 标签
 */
@Configuration
public class FreeMarkerConfig {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;


    @Autowired
    private FreeMarkerViewResolver resolver;


    @PostConstruct
    public void setSharedVariable() {
        try {
            // 加上这句后，可以在页面上使用shiro标签
            freeMarkerConfigurer.getConfiguration().setSharedVariable("shiro", new ShiroTags());
            // 加上这句后，可以在页面上用${context.contextPath}获取contextPath
            resolver.setRequestContextAttribute("context");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
