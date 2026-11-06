
package com.stenographer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

@Controller
public class UploadController {

    @PostMapping("/upload")
    public String uploadImage(
            @RequestParam("image") MultipartFile image,
            Model model) {

        if (image.isEmpty()) {
            model.addAttribute("message", "Please select an image.");
            return "index";
        }

        model.addAttribute("message",
                "Image uploaded successfully: " + image.getOriginalFilename());

        return "index";
    }
}
