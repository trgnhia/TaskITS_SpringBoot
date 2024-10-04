package com.electricbill.dto;

public class BillRespone {
    private Double TongTien;
    public BillRespone(Double TongTien) {
        this.TongTien = TongTien;
    }

    public Double getTongTien() {
        return TongTien;
    }

    public void setTongTien(Double tongTien) {
        TongTien = tongTien;
    }
}
