package com.forgeeks.SpringDZ5.controllers;

import com.forgeeks.SpringDZ5.dto.ProductDto;
import com.forgeeks.SpringDZ5.entities.Product;
import com.forgeeks.SpringDZ5.utils.AspectApp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/statistic")
@RequiredArgsConstructor
public class StatisticsController {
    public final AspectApp aspectApp;


    @GetMapping
    public List<String> getTime() {
        List <String> timeList = new ArrayList<>();
        timeList.add("CartService: " + aspectApp.getCartServTime());
        timeList.add("Ultimate: " + aspectApp.getUltimateTime());
        return timeList;
//        return Collections.singletonList("Ultimate worktime is:" + aspectApp.getUltimateTime());
    }
}
