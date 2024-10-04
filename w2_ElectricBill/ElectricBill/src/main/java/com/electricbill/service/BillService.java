package com.electricbill.service;

import com.electricbill.Entity.HistoryBill;
import com.electricbill.Repository.BillRepository;
import com.electricbill.Repository.PriceRepository;
import com.electricbill.dto.BillRequest;
import com.electricbill.dto.BillRespone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepo;

    @Autowired
    private PriceRepository pr;

    public BillRespone Calculate(BillRequest request){
        double res = TinhTien(request.getKwUsed());

        HistoryBill hb = new HistoryBill();
        hb.setKwUsed(request.getKwUsed());
        hb.setBillDate(request.getBillDate());
        hb.setTongTien(res);
        billRepo.save(hb);
        return new BillRespone(res);
    }

    private double TinhTien(double kWhUsed) {
        double total = 0.0;
        if (kWhUsed <= 50) {
            total = kWhUsed * 1806;
        } else if (kWhUsed <= 100) {
            total = (50 * 1806) + ((kWhUsed - 50) * 1866);
        } else if (kWhUsed <= 200) {
            total = (50 * 1806) + (50 * 1866) + ((kWhUsed - 100) * 2167);
        } else if (kWhUsed <= 300) {
            total = (50 * 1806) + (50 * 1866) + (100 * 2167) + ((kWhUsed - 200) * 2729);
        } else if (kWhUsed <= 400) {
            total = (50 * 1806) + (50 * 1866) + (100 * 2167) + (100 * 2729) + ((kWhUsed - 300) * 3050);
        } else {
            total = (50 * 1806) + (50 * 1866) + (100 * 2167) + (100 * 2729) + (100 * 3050) + ((kWhUsed - 400) * 3151);
        }
        return total;
    }

}
