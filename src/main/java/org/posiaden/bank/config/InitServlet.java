package org.posiaden.bank.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Set base path for Spring, set config class
public class InitServlet extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{BankConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
