package com.electricbill.Controller;

import com.electricbill.Entity.ElecPrice;
import com.electricbill.dto.PriceRequest;
import com.electricbill.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PriceController {
    @Autowired
    private PriceService prsv;

    @PostMapping("/add")
    public ElecPrice add(@RequestBody PriceRequest request) {
        return prsv.savePrice(request);
    }
}
