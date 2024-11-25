package com.AvirantEnterprises.InfoCollector_AE.repository;

import com.AvirantEnterprises.InfoCollector_AE.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    // Custom queries if necessary
}
