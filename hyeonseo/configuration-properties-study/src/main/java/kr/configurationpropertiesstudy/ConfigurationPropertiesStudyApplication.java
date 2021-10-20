package kr.configurationpropertiesstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MyProperties.class)
public class ConfigurationPropertiesStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationPropertiesStudyApplication.class, args);
	}

}