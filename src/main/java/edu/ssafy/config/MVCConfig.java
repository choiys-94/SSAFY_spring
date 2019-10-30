package edu.ssafy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
// <mvc:annotation-driven>과 같은 역할
@ComponentScan("edu.ssafy.controller")
// <context:component-scan base-pacakge="">과 같은 역할
public class MVCConfig extends WebMvcConfigurerAdapter{
	
}
