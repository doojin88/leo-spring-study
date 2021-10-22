package kr.configurationpropertiesstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    MyProperties myProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(myProperties.getName());
        System.out.println(myProperties.getAge());
        System.out.println(myProperties.getFullName());


    }
}
