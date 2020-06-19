package com.tyc.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: tangych
 * created on 2020/06/19
 **/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="com.tyc.controller")
public class WebConfig {



  @Bean(name = "internalResourceViewResolver")
  public ViewResolver viewResolver(){
    InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
    internalResourceViewResolver.setPrefix("/web/WEB-INF/pages");
    internalResourceViewResolver.setSuffix(".jsp");
    return internalResourceViewResolver;
  }

  @Bean(name="requestMappingHandlerAdapter")
  public HandlerAdapter handlerAdapter(){
    RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
    List<MediaType> mediaTypes = new ArrayList();
    mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
    mappingJackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypes);
    requestMappingHandlerAdapter.getMessageConverters().add(mappingJackson2HttpMessageConverter);
    return requestMappingHandlerAdapter;
  }

}
