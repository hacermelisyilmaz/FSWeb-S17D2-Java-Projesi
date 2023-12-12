package com.workintech.spring.developer.rest;

import com.workintech.spring.developer.enums.Experience;
import com.workintech.spring.developer.model.Developer;
import com.workintech.spring.developer.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public Developer getDeveloper(@PathVariable int id) {
        return developers.get(id);
    }

    @PostMapping
    public void addDeveloper(@RequestBody int id, @RequestBody String name, @RequestBody double salary, @RequestBody Experience experience) {
        double salaryAfterTax = salary;
        switch (experience) {
            case JUNIOR -> salaryAfterTax = salary * (1 - developerTax.getSimpleTaxRate());
            case MID -> salaryAfterTax = salary * (1 - developerTax.getMiddleTaxRate());
            case SENIOR -> salaryAfterTax = salary * (1 - developerTax.getUpperTaxRate());
        }
        developers.put(id, new Developer(id, name, salaryAfterTax, experience));
    }

    @PutMapping("/{id}")
    public void updateDeveloper(@RequestBody Developer developer) {
        developers.put(developer.getId(), developer);
    }
}
