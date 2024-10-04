package com.electricbill.Controller;

import com.electricbill.dto.BillRequest;
import com.electricbill.dto.BillRespone;
import com.electricbill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService bsv;

    @PostMapping("/calculate")
    public BillRespone TongBill(@RequestBody BillRequest request) {
        return bsv.Calculate(request);
    }

}
