package com.autosell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
public class AutosellApplication extends SpringBootServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("orderPoint", "2");
        servletContext.setInitParameter("pointToCurrency", "20");

        super.onStartup(servletContext);
    }

    public static void main(String[] args) {
        SpringApplication.run(AutosellApplication.class, args);
    }

}
