package com.electricbill.Repository;

import com.electricbill.Entity.ElecPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<ElecPrice, Long> {

}
