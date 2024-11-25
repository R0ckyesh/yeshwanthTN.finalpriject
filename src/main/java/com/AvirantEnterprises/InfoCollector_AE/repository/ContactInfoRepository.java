package com.AvirantEnterprises.InfoCollector_AE.repository;

import com.AvirantEnterprises.InfoCollector_AE.model.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
    // You can add custom queries here if needed
}
