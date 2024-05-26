package com.melnikov.webapp.service;

import com.melnikov.webapp.model.UserRating;
import com.melnikov.webapp.repository.UserRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRatingService {

    @Autowired
    private UserRatingRepository userRatingRepository;

    public void save(UserRating userRating) {
        userRatingRepository.save(userRating);
    }
}
