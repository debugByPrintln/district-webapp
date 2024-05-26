package com.melnikov.webapp.controller;

import com.melnikov.webapp.model.District;
import com.melnikov.webapp.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping("/districts")
    public String showDistricts(Model model) {
        List<District> districts = districtService.findAll();
        model.addAttribute("districts", districts);
        return "show";
    }
}
