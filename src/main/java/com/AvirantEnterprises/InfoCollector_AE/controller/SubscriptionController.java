package com.AvirantEnterprises.InfoCollector_AE.controller;

import com.AvirantEnterprises.InfoCollector_AE.model.Subscription;
import com.AvirantEnterprises.InfoCollector_AE.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@RestController

public class SubscriptionController {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    private final String uploadDir = "/path/to/upload/directory";  // Define your file storage directory

    @PostMapping("/subscribe")
    public String subscribe(@RequestParam String plan, @RequestParam MultipartFile file) throws IOException {
        // Save file to the file system
        String fileName = file.getOriginalFilename();
        Path filePath = Path.of(uploadDir, fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Store the file path in the database
        Subscription subscription = new Subscription();
        subscription.setPlan(plan);
        subscription.setFilePath(filePath.toString());

        subscriptionRepository.save(subscription);

        return "Subscription successful!";
    }
}
