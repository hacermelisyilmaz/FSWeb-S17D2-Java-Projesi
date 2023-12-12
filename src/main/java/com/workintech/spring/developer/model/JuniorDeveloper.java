package com.workintech.spring.developer.model;

import com.workintech.spring.developer.enums.Experience;
import org.springframework.stereotype.Component;

@Component
public class JuniorDeveloper extends Developer {
    public JuniorDeveloper(int id, String name, int salary, Experience experience) {
        super(id, name, salary, experience);
    }
}
