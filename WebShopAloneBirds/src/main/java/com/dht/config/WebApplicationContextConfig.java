/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.config;

/**
 *
 * @author dt_ng
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.dht.springmvcdemo.controller")
public class WebApplicationContextConfig implements WebMvcConfigurer {
  @Override
  public void configureDefaultServletHandling(
                           DefaultServletHandlerConfigurer configurer) {
      configurer.enable();
  } 
  @Bean
  public InternalResourceViewResolver getInternalResourceViewResolver(){
      InternalResourceViewResolver resolver 
                                   = new InternalResourceViewResolver();
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/jsp/");
      resolver.setSuffix(".jsp");
        
      return resolver;
  }
  @Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {

     registry.addResourceHandler("/images/**")
            .addResourceLocations("/resources/images/");
      registry.addResourceHandler("/css/**")
            .addResourceLocations("/resources/css/");
 registry.addResourceHandler("/fonts/**")
            .addResourceLocations("/resources/fonts/");
 registry.addResourceHandler("/js/**")
            .addResourceLocations("/resources/js/");


}
@Bean
public CommonsMultipartResolver multipartResolver() {
    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    resolver.setDefaultEncoding("UTF-8");

    return resolver;
}
}
