package com.AvirantEnterprises.InfoCollector_AE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThankYouController {

    @GetMapping("/thank-you")
    public String thankYouPage() {
        return "thank-you";  // Display the "Thank You" page
    }
    @GetMapping("/go-dashboard")
    public String dashboardpage() {
        return "dashboard";  // Display the "Thank You" page
    }
}
