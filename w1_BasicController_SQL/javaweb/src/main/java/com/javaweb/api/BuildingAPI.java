package com.javaweb.api;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BuildingAPI {
    @GetMapping("/api/building/")
    //http://localhost:8082/api/building/?name=HEHE building&numberOfBasement=3&ward=Tan Mai &Street=Ly Thai To
    //URL trong postman
    public String building(@RequestParam(value = "name", required = false) String buildName,
                           @RequestParam(value = "numberOfBasement",required = false) String numberOfBasement,
                           @RequestParam(value = "ward",required = false) String ward,
                           @RequestParam(value = "Street",required = false) String street) {
        System.out.println(buildName + " " + numberOfBasement + " " + ward + " " + street);
        return buildName + " " + numberOfBasement + " " + ward + " " + street;
    }

    @PostMapping("/api/building/")
    // file JSON trong postman de post data
//    {
//        "name" : "",
//            "numberOfBasement" : 4,
//            "ward" : "Tan Mai"
//    }

    public void getBuilding(@RequestBody Map<String, String> building){
        System.out.println(building);
    }

}
