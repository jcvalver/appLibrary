package com.teczuka.devp.appLibrary.configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.teczuka.devp.appLibrary.controller"})
public class WebAppConfig extends WebMvcConfigurerAdapter{		
	
	/* @Bean  
	    public InternalResourceViewResolver setupViewResolver() {  
	    	InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
	        resolver.setPrefix("/WEB-INF/views/");  
	        resolver.setSuffix(".jsp");  
	        resolver.setViewClass(JstlView.class);  
	        return resolver;  
	    }	
	 */
	
	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp"); 
    }
	

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       /* registry.addResourceHandler("/static/**")
                .addResourceLocations("/public/", "/webjars/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.MINUTES))
                .resourceChain(true);
                */
    	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/","/resources/css/","/resources/js/");
    }
}
