package com.electricbill.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class HistoryBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate billDate;
    private Double KwUsed;
    private Double TongTien;

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
