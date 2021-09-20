//package com.example.botforitmed.component;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import uz.jsd.onlineschoolserver.entity.District;
//import uz.jsd.onlineschoolserver.entity.Region;
//import uz.jsd.onlineschoolserver.exception.ResourceNotFoundException;
//import uz.jsd.onlineschoolserver.repository.DistrictRepository;
//
//@Component("ValueHelper")
//public class ValueHelper {
//    @Autowired
//    DistrictRepository districtRepository;
//
//    public Region getRegionofDistrict(District district) {
//        Region region=null;
//        if (district!=null){
//             region=districtRepository.findById(district.getId()).orElseThrow(() -> new ResourceNotFoundException("districtId", "districtId", district)).getRegion();
//        }
//        return region;
//    }
//}
