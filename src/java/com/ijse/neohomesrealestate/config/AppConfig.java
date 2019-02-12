/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author vinod
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ijse.neohomesrealestate")
public class AppConfig extends WebMvcConfigurerAdapter {

    private int maxUploadSizeInMb = 10 * 1024 * 1024;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assests/**").addResourceLocations("/assests/");
        super.addResourceHandlers(registry);
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
        CommonsMultipartResolver cms = new CommonsMultipartResolver();
        cms.setMaxUploadSize(maxUploadSizeInMb);
        return cms;
    }
}
//
//<div><img src="data:image/jpg;base64,"<%= advertistmentDto.getImageList().get(1) %> alt=""></div>
//                                        <div><img src="data:image/jpg;base64,"<%= advertistmentDto.getImageList().get(2) %> alt=""></div>
//                                        <div><img src="data:image/jpg;base64,"<%= advertistmentDto.getImageList().get(3) %> alt=""></div>
