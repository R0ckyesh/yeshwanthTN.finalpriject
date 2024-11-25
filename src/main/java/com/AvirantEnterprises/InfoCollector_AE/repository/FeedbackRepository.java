package com.AvirantEnterprises.InfoCollector_AE.repository;

import com.AvirantEnterprises.InfoCollector_AE.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // You can add custom queries if needed
}
