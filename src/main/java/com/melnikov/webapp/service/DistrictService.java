package com.melnikov.webapp.service;

import com.melnikov.webapp.model.District;
import com.melnikov.webapp.model.UserRating;
import com.melnikov.webapp.repository.DistrictRepository;
import com.melnikov.webapp.repository.UserRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private UserRatingRepository userRatingRepository;

    public List<District> findAll() {
        return districtRepository.findAll();
    }

    public Optional<District> findById(Long id){
        return districtRepository.findById(id);
    }

    public void updateDistrictRate(District district) {
        List<UserRating> userRatings = userRatingRepository.findAllByDistrict(district);
        int size = userRatings.size();
        double security = 0;
        double cost = 0;
        double health = 0;
        double livability = 0;
        double transport = 0;
        double education = 0;
        double novelty = 0;
        double density = 0;
        double remoteness = 0;
        double quietness = 0;
        for (UserRating userRating: userRatings) {
            security += userRating.getSecurity();
            cost += userRating.getCost();
            health += userRating.getHealth();
            livability += userRating.getLivability();
            transport += userRating.getTransport();
            education += userRating.getEducation();
            novelty += userRating.getNovelety();
            density += userRating.getDensity();
            remoteness += userRating.getRemoteness();
            quietness += userRating.getQuietness();
        }
        district.setSecurity(round(security/size));
        district.setCost(round(cost / size));
        district.setHealth(round(health / size));
        district.setLivability(round(livability / size));
        district.setTransport(round(transport / size));
        district.setEducation(round(education / size));
        district.setNovelety(round(novelty / size));
        district.setDensity(round(density / size));
        district.setRemoteness(round(remoteness / size));
        district.setQuietness(round(quietness / size));
        districtRepository.save(district);
    }

    private double round(double d){
        return Math.round(d * 10.0) / 10.0;
    }
}
