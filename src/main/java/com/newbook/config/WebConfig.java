package com.newbook.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.List;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.newbook.controller")
public class WebConfig implements WebMvcConfigurer
{

	public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
	{
		final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ"));
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.setVisibility(new FieldVisibilityChecker());
		objectMapper.enable(JsonParser.Feature.ALLOW_COMMENTS);

		SimpleModule module = new SimpleModule();
		objectMapper.registerModule(module);


		converter.setObjectMapper(objectMapper);
		converters.add(converter);
	}

	public static class FieldVisibilityChecker extends VisibilityChecker.Std
	{
		public FieldVisibilityChecker()
		{
			super(JsonAutoDetect.Visibility.ANY);
		}

		@Override
		public boolean isGetterVisible(Method var1)
		{
			return false;
		}

		@Override
		public boolean isGetterVisible(AnnotatedMethod var1)
		{
			return false;
		}

		@Override
		public boolean isIsGetterVisible(Method var1)
		{
			return false;
		}

		@Override
		public boolean isIsGetterVisible(AnnotatedMethod var1)
		{
			return false;
		}

		@Override
		public boolean isSetterVisible(Method var1)
		{
			return false;
		}

		@Override
		public boolean isSetterVisible(AnnotatedMethod var1)
		{
			return false;
		}

		@Override
		public boolean isCreatorVisible(Member var1)
		{
			return false;
		}

		@Override
		public boolean isCreatorVisible(AnnotatedMember var1)
		{
			return false;
		}
	}

}
