package edu.ssafy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.ssafy.dto.MemberDTO;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AppConfig {
	
	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2)
		.groupName("SSAFY")
		.apiInfo(info())
		.select()
		.apis(RequestHandlerSelectors.basePackage("edu.ssafy.controller"))
		.paths(PathSelectors.ant("/api/**"))
		.build();
	}
	
	public ApiInfo info() {
		return new ApiInfoBuilder()
				.title("SSAFY API")
				.license("SSAFY만 그냥 써요")
				.version("0.9")
				.build();
	}
	
	@Bean
	public MemberDTO getMemberDTO() {
		return new MemberDTO("200", "200", "200", "200");
	}
}
