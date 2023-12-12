package com.workintech.spring.developer.model;

import com.workintech.spring.developer.enums.Experience;
import org.springframework.stereotype.Component;

@Component
public class SeniorDeveloper extends Developer {
    public SeniorDeveloper(int id, String name, int salary, Experience experience) {
        super(id, name, salary, experience);
    }
}
