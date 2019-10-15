package com.spring.start.z_startup.configuration;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@EnableAutoConfiguration
public class SwaggerConfig extends WebMvcConfigurationSupport {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		  registry.addResourceHandler("/webjars/**")
          .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	public Docket postsApi() {
		
		return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(
		        Arrays.asList(new ParameterBuilder()
		                .name(Constants.HEADER_AUTH)
		                .description("Authorization of Request using token")
		                .modelRef(new ModelRef("string"))
		                .parameterType("header")
		                .required(false)
		                .build())).groupName("startUp-api").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.spring.start.z_startup.controller")).paths(postPaths()).build();

	}

	private Predicate<String> postPaths() {
		return or(regex("/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("StartUp API").description("StartUp API reference for developers")
				.termsOfServiceUrl("http://StartUp.com").contact("StartUp@gmail.com").license("StartUp License")
				.licenseUrl("StartUp@gmail.com").version("1.0").build();
	}

}