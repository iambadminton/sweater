package com.example.sweater.config;

/**
 * Created by Sanya on 22.01.2019.
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${upload.path}")
    private String uploadPath;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    // оверрайдим
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // это означает, что по запросу по пути img мы будем перенаправлять по пути file://{uploadPath}/
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:///" + uploadPath +"/");

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/"); //classpath означает,
        // что ресурсы будут искаться не где-то в файловой системе, а в дереве проекта
    }
}