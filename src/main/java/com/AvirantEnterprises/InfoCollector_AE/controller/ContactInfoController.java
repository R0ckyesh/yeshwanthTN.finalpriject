package com.AvirantEnterprises.InfoCollector_AE.controller;

import com.AvirantEnterprises.InfoCollector_AE.model.ContactInfo;

import com.AvirantEnterprises.InfoCollector_AE.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ContactInfoController {

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    // Show the contact info form
    @GetMapping("/contact-info")
    public String showContactInfoForm(Model model) {
        model.addAttribute("contactInfo", new ContactInfo());
        return "contact-info";  // Corresponds to contact-info.html (the HTML file provided)
    }

    // Handle the form submission
    @PostMapping("/submit-contact-info")
    public String submitContactInfo(@ModelAttribute ContactInfo contactInfo) {
        // Save the contact information to the database
        contactInfoRepository.save(contactInfo);

        // Redirect to a thank you page or another success page
        return "redirect:/thank-you";
    }
}
