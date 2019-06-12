package com.chl.gbo.cental.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: BoYanG
 * @Describe test
 * @Date 2019/6/12 15:15
 */
@Component
@ConfigurationProperties(prefix = "me")
public class Me {

    private String name;
    private String age;
    private String tall;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTall() {
        return tall;
    }

    public void setTall(String tall) {
        this.tall = tall;
    }
}
