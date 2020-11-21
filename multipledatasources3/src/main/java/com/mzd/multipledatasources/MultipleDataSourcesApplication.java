package com.mzd.multipledatasources;

import com.mzd.multipledatasources.datasource.Datasource1;
import com.mzd.multipledatasources.datasource.Datasource2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
// @EnableConfigurationProperties注解使@ConfigurationProperties注解生效
@EnableConfigurationProperties(value = { Datasource1.class, Datasource2.class })
public class MultipleDataSourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDataSourcesApplication.class, args);
	}
}
