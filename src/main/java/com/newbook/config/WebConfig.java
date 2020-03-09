package com.newbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.newbook.controller")
public class WebConfig implements WebMvcConfigurer
{

	@Bean
	public ViewResolver getViewResolver()
	{
		FreeMarkerViewResolver res = new FreeMarkerViewResolver();
		res.setOrder(1);
		res.setSuffix(".ftl");
		res.setPrefix("");
		return res;
	}

	@Bean
	public FreeMarkerConfigurer getFreeMarkerConfigurer()
	{
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPaths("/", "/WEB-INF/views/");
		return freeMarkerConfigurer;
	}
}
