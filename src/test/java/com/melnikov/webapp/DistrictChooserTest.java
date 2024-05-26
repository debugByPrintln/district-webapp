package com.melnikov.webapp;

import com.melnikov.webapp.district_choose.DistrictChooser;
import com.melnikov.webapp.model.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DistrictChooserTest {
    @Autowired
    DistrictChooser districtChooser;

    @Test
    void test(){
//        District idealDistrict = new District();
//        idealDistrict.setQuietness(90.0);
//        idealDistrict.setEducation(90.0);
//        idealDistrict.setHealth(90.0);
//        idealDistrict.setTransport(90.0);
//        idealDistrict.setCost(90.0);
//        idealDistrict.setLivability(90.0);
//        idealDistrict.setDensity(90.0);
//        idealDistrict.setNovelety(90.0);
//        idealDistrict.setSecurity(90.0);
//        idealDistrict.setRemoteness(90.0);
//
//        District currentDistrict1 = new District();
//        currentDistrict1.setName("A");
//        currentDistrict1.setQuietness(10.0);
//        currentDistrict1.setEducation(10.0);
//        currentDistrict1.setHealth(10.0);
//        currentDistrict1.setTransport(10.0);
//        currentDistrict1.setCost(10.0);
//        currentDistrict1.setLivability(10.0);
//        currentDistrict1.setDensity(10.0);
//        currentDistrict1.setNovelety(10.0);
//        currentDistrict1.setSecurity(10.0);
//        currentDistrict1.setRemoteness(10.0);
//
//        District currentDistrict2 = new District();
//        currentDistrict2.setName("B");
//        currentDistrict2.setQuietness(90.0);
//        currentDistrict2.setEducation(90.0);
//        currentDistrict2.setHealth(90.0);
//        currentDistrict2.setTransport(90.0);
//        currentDistrict2.setCost(70.0);
//        currentDistrict2.setLivability(90.0);
//        currentDistrict2.setDensity(90.0);
//        currentDistrict2.setNovelety(90.0);
//        currentDistrict2.setSecurity(90.0);
//        currentDistrict2.setRemoteness(90.0);
//
//        List<District> list = new ArrayList<>();
//        list.add(currentDistrict1);
//        list.add(currentDistrict2);
//
//        District district = districtChooser.calculateClosesDistrict(idealDistrict, list);
//        System.out.println(district);

//        double marker = districtChooser.calculateMarker(idealDistrict, currentDistrict1);
//        System.out.println(marker);

        double surplus = districtChooser.calculateIteration(1.2, 9.9, 10);
        System.out.println(surplus);
    }
}
