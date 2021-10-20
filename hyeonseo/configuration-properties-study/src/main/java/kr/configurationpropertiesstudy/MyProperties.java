package kr.configurationpropertiesstudy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "my")
public class MyProperties {

    private String name;
    private int age;
    private String fullName;
}