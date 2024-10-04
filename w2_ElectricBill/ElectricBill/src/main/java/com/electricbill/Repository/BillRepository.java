package com.electricbill.Repository;

import com.electricbill.Entity.HistoryBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<HistoryBill, Long> {
}
