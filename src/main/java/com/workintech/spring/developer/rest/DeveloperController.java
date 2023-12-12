package com.workintech.spring.developer.rest;

import com.workintech.spring.developer.model.Developer;
import com.workintech.spring.developer.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("workintech/developers")
public class DeveloperController {
    private Taxable developerTax;
    Map<Integer, Developer> developers;

    @Autowired
    public DeveloperController(@Qualifier Taxable developerTax) {
        this.developerTax = developerTax;
    }

    @PostConstruct
    public void initializeDevelopersMap() {
        developers = new HashMap<>();
    }

    @GetMapping
    public List getDevelopers() {
        return developers.values().stream().toList();
    }
}
