package com.deliveryboy.api;

import com.deliveryboy.config.AppConstants;
import com.deliveryboy.service.KafkaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(AppConstants.BASE_URL+"/location")
public class LocationResource {

    private final KafkaService kafkaService;

    public LocationResource(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){

        this.kafkaService.updateLocation("( "+Math.round(Math.random()*100)+" , "+ Math.round( Math.random()*100)+" )" );
        return new ResponseEntity<>(Map.of("message","Location updated"), HttpStatus.OK);
    }

}
