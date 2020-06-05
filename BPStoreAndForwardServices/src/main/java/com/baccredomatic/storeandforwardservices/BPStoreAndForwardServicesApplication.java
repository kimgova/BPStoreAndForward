package com.baccredomatic.storeandforwardservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

import com.baccredomatic.storeandforwardservices.config.YAMLConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@RestController
@EnableSwagger2
public class BPStoreAndForwardServicesApplication extends SpringBootServletInitializer{

	@Autowired
    private YAMLConfig appConfig;
	
	public static void main(String[] args) {
        SpringApplication.run(BPStoreAndForwardServicesApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {	     
		return application.sources(BPStoreAndForwardServicesApplication.class);
    }

}
