//package com.zhou.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
//
//import javax.servlet.ServletContext;
//
//@Configuration
//public class ThymeleafConfig {
//
//
//    @Bean
//    public ResourceBundleMessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("messages");
//        messageSource.setDefaultEncoding("UTF-8");
//
//        return messageSource;
//    }
//
////    ServletContext
//
//    @Bean
//    public ServletContextTemplateResolver defaultTemplateResolver() {
//        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
//        resolver.setPrefix("/templates/");
//        resolver.setSuffix(".html");
//        resolver.setTemplateMode("LEGACYHTML5");
//        resolver.setCacheable(false);
//        return resolver;
//    }
//}
