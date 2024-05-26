package com.melnikov.webapp.district_choose;

import com.melnikov.webapp.model.District;
import com.melnikov.webapp.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DistrictChooser {
    private final double securityWeight = 1.2;
    private final double costWeight = 1.18;
    private final double healthWeight = 1.16;
    private final double livabilityWeight = 1.14;
    private final double transportWeight = 1.12;
    private final double educationWeight = 1.10;
    private final double noveltyWeight = 1.08;
    private final double densityWeight = 1.06;
    private final double remotenessWeight = 1.04;
    private final double quietnessWeight = 1.02;

    @Autowired
    DistrictRepository districtRepository;

    public DistrictChooser() {
    }

    public District chooseDistrict(District idealDistrict){
        List<District> districts = districtRepository.findAll();
        return calculateClosesDistrict(idealDistrict, districts);
    }

    public District calculateClosesDistrict(District idealDistrict, List<District> districts){
        double minimalMarker = Double.MAX_VALUE;
        District closesDistrict = null;

        for (District currentDistrict : districts) {
            double marker = calculateMarker(idealDistrict, currentDistrict);
            if (marker < minimalMarker){
                minimalMarker = marker;
                closesDistrict = currentDistrict;
            }
        }
        return closesDistrict;
    }

    public double calculateMarker(District idealDistrict, District currentDistrict){
        double marker = 0;
        marker += calculateIteration(securityWeight, idealDistrict.getSecurity(), idealDistrict.getSecurity());
        marker += calculateIteration(quietnessWeight, idealDistrict.getQuietness(), currentDistrict.getQuietness());
        marker += calculateIteration(educationWeight, idealDistrict.getEducation(), currentDistrict.getEducation());
        marker += calculateIteration(healthWeight, idealDistrict.getHealth(), currentDistrict.getHealth());
        marker += calculateIteration(transportWeight, idealDistrict.getTransport(), currentDistrict.getTransport());
        marker += calculateIteration(costWeight, idealDistrict.getCost(), currentDistrict.getCost());
        marker += calculateIteration(livabilityWeight, idealDistrict.getLivability(), currentDistrict.getLivability());
        marker += calculateIteration(densityWeight, idealDistrict.getDensity(), currentDistrict.getDensity());
        marker += calculateIteration(noveltyWeight, idealDistrict.getNovelety(), currentDistrict.getNovelety());
        marker += calculateIteration(remotenessWeight, idealDistrict.getRemoteness(), currentDistrict.getRemoteness());
        return marker;
    }

    public double calculateIteration(double weight, double idealCriteria, double actualCriteria){
        double absoluteValue = Math.abs(actualCriteria - idealCriteria);
        if (absoluteValue == 0){
            return 0;
        }
        if (absoluteValue <= 1){
            absoluteValue = 1.1;
        }
        return (weight * Math.log10(absoluteValue));
    }
}
