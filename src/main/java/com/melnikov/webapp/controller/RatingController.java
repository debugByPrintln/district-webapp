package com.melnikov.webapp.controller;

import com.melnikov.webapp.model.District;
import com.melnikov.webapp.model.User;
import com.melnikov.webapp.model.UserRating;
import com.melnikov.webapp.repository.DistrictRepository;
import com.melnikov.webapp.repository.UserRatingRepository;
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
public class RatingController {

    @Autowired
    private DistrictService districtService;

    @Autowired
    private UserRatingService userRatingService;

    @GetMapping("/rate")
    public String showRatingForm(Model model, HttpSession session) {
        List<District> districts = districtService.findAll();
        model.addAttribute("districts", districts);
        return "rate";
    }

    @PostMapping("/rate")
    public String submitRating(@RequestParam Long districtId,
                               @RequestParam Double quietness,
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

        User user = (User) session.getAttribute("user");
        District district = districtService.findById(districtId).get();
        UserRating userRating = new UserRating(quietness, education, health, transport, cost,
                livability, density, novelty, security, remoteness, user, district);
        userRatingService.save(userRating);
        districtService.updateDistrictRate(district);
        model.addAttribute("message", "Оценка выставлена!");
        return showRatingForm(model, session);
    }
}