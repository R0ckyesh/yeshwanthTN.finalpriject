package com.AvirantEnterprises.InfoCollector_AE.controller;

import com.AvirantEnterprises.InfoCollector_AE.model.Feedback;
import com.AvirantEnterprises.InfoCollector_AE.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @PostMapping("/submit-feedback")
    public String submitFeedback(@RequestParam String feedback, Model model) {
        // Create a new Feedback object with the feedback text
        Feedback feedbackEntry = new Feedback(feedback);

        // Save the feedback to the database
        feedbackRepository.save(feedbackEntry);

        // Add a success message to the model
        model.addAttribute("success", "Thank you for your feedback!");

        // Redirect to the confirmation page
        return "thank-you";  // This refers to the feedback-confirmation.html page
    }
}
