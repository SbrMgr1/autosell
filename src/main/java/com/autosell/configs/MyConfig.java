package com.autosell.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableWebMvc
public class MyConfig implements WebMvcConfigurer {


    @Bean("messageSource")
    public MessageSource messageSource() {

        ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/css_resources/**")
                .addResourceLocations("/public", "classpath:/static/css/")
                .setCachePeriod(31556926);
        registry.addResourceHandler("/font_awesome_resources/**")
                .addResourceLocations("/public", "classpath:/static/font-awesome/css/")
                .setCachePeriod(31556926);
        registry.addResourceHandler("/fonts/**")
                .addResourceLocations("/public", "classpath:/static/fonts/")
                .setCachePeriod(31556926);
        registry.addResourceHandler("/js_resources/**")
                .addResourceLocations("/public", "classpath:/static/js/")
                .setCachePeriod(31556926);

        registry.addResourceHandler("/image_resources/**")
                .addResourceLocations("/public", "classpath:/static/images/")
                .setCachePeriod(31556926);

    }
    @Bean
    public LocalValidatorFactoryBean validator(){

        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;

    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        return localeResolver;
    }



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("locale");
        registry.addInterceptor(localeChangeInterceptor);
    }

//    @Bean
//    public CommonsMultipartResolver commonsMultipartResolver(){
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setMaxInMemorySize(10240000);
//        return commonsMultipartResolver;
//    }
}
