package com.api.book.bootrestbook.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.bootrestbook.helper.FileUploadHelper;

@RestController
public class FileUpload {

    
    @Autowired
    FileUploadHelper fileUploadHelper;

    @PostMapping("/fileU")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) {

        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }
            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("must be jpg content ");
            }
            
            // System.out.println(file.getOriginalFilename());
            // System.out.println(file.getSize());
            // System.out.println(file.getContentType());
            // System.out.println(file.getName());

            boolean f=fileUploadHelper.uploadFile(file);
            if(f){
                // return ResponseEntity.ok("File uploaded sccessflly");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something wents wrong");

        
    }
}
