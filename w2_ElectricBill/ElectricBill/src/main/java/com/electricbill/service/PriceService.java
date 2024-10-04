package com.electricbill.service;

import com.electricbill.Entity.ElecPrice;
import com.electricbill.Repository.PriceRepository;
import com.electricbill.dto.PriceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    @Autowired
    private PriceRepository pr;

    public ElecPrice savePrice(PriceRequest request){
        ElecPrice price = new ElecPrice();
        price.setSoDien(request.getSoDien());
        return pr.save(price);
    }
}
