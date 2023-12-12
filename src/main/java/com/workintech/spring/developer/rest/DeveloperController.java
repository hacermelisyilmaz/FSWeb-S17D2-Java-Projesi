package com.workintech.spring.developer.rest;

import com.workintech.spring.developer.model.Developer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
    Map<Integer, Developer> developers = new HashMap<>();
}
