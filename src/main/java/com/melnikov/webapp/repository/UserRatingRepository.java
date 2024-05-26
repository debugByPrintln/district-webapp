package com.melnikov.webapp.repository;

import com.melnikov.webapp.model.District;
import com.melnikov.webapp.model.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRating, Long> {
    List<UserRating> findAllByDistrict(District district);
}
