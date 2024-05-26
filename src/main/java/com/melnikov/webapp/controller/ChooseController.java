package com.melnikov.webapp.controller;

import com.melnikov.webapp.district_choose.DistrictChooser;
import com.melnikov.webapp.model.District;
import com.melnikov.webapp.model.User;
import com.melnikov.webapp.model.UserRating;
import com.melnikov.webapp.service.DistrictService;
import com.melnikov.webapp.service.UserRatingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChooseController {

    @Autowired
    private DistrictChooser districtChooser;

    @GetMapping("/choose")
    public String showChooseForm(Model model, HttpSession session) {
        return "choose";
    }

    @PostMapping("/choose")
    public String submitChoose(@RequestParam Double quietness,
                               @RequestParam Double education,
                               @RequestParam Double health,
                               @RequestParam Double transport,
                               @RequestParam Double cost,
                               @RequestParam Double livability,
                               @RequestParam Double density,
                               @RequestParam Double novelty,
                               @RequestParam Double security,
                               @RequestParam Double remoteness,
                               HttpSession session,
                               Model model) {
        District idealDistrict = new District();
        idealDistrict.setQuietness(quietness);
        idealDistrict.setEducation(education);
        idealDistrict.setHealth(health);
        idealDistrict.setTransport(transport);
        idealDistrict.setCost(cost);
        idealDistrict.setLivability(livability);
        idealDistrict.setDensity(density);
        idealDistrict.setNovelety(novelty);
        idealDistrict.setSecurity(security);
        idealDistrict.setRemoteness(remoteness);
        District district = districtChooser.chooseDistrict(idealDistrict);
        model.addAttribute("chosenDistrict", "Вам подходит район: " + district.getName() + "!");
        return showChooseForm(model, session);
    }
}