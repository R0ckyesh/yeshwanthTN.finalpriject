package com.AvirantEnterprises.InfoCollector_AE.controller;

import com.AvirantEnterprises.InfoCollector_AE.model.User;
import com.AvirantEnterprises.InfoCollector_AE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class updateregister {

    // Autowire UserRepository to access the instance of the repository
    @Autowired
    private UserRepository userRepository;

    // Handle password update by email
    @PostMapping("/update-password")
    public String updatePassword(@RequestParam String email,
                                 @RequestParam String newPassword,
                                 @RequestParam String confirmPassword, Model model) {

        // Check if the passwords match
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            return "update-password"; // Return to the password update page if passwords don't match
        }

        // Find user by email using the autowired repository instance
        User user = userRepository.findByEmail(email);
        if (user == null) {
            model.addAttribute("error", "User not found with the provided email.");
            return "update-password"; // Return to the password update page if user is not found
        }

        // Update the user's password
        user.setPassword(newPassword);
        userRepository.save(user);  // Save the updated user to the database

        model.addAttribute("success", "Password updated successfully!");
        return "thank-you"; // Return to the update-password page with a success message
    }
}
