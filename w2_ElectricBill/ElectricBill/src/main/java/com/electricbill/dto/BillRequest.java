package com.electricbill.dto;


import java.time.LocalDate;

public class BillRequest {
    private LocalDate billDate;
    private Double KwUsed;
    private Double TongTien;

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public Double getKwUsed() {
        return KwUsed;
    }

    public void setKwUsed(Double kwUsed) {
        KwUsed = kwUsed;
    }

    public Double getTongTien() {
        return TongTien;
    }

    public void setTongTien(Double tongTien) {
        TongTien = tongTien;
    }
}
