package com.baimahu.SpringbootBasic.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

//@PropertySource("classpath:person.properties")
//@PropertySource(value = {"classpath:person.properties"})
@PropertySource("classpath:application.yml")
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private String hometown;
    private Date birthday;

    private Map<String, String> maps;
    private ArrayList<String> hobbies;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hometown='" + hometown + '\'' +
                ", birthday=" + birthday +
                ", maps=" + maps +
                ", hobbies=" + hobbies +
                ", dog=" + dog +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
