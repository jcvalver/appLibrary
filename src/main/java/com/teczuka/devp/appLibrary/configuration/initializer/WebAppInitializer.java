package com.teczuka.devp.appLibrary.configuration.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.teczuka.devp.appLibrary.configuration.WebAppConfig;
import com.teczuka.devp.appLibrary.configuration.WebAppDataConfig;
import com.teczuka.devp.appLibrary.configuration.WebSecurityConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppDataConfig.class, WebSecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
