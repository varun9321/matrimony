package com.oms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    // equivalents for <mvc:resources/> tags
	 @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("~/resources/css/**").addResourceLocations("/resources/css/");
    	registry.addResourceHandler("~/resources/js/**").addResourceLocations("/resources/js/");
    	registry.addResourceHandler("~/resources/fonts/**").addResourceLocations("/resources/fonts/");
    }

    // equivalent for <mvc:default-servlet-handler/> tag
	

	
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // ... other stuff ...
}