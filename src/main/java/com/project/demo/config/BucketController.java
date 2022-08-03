package com.project.demo.config;

import com.project.demo.util.CloudStorageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
public class BucketController {
    @Autowired
    CloudStorageHelper cloudStorageHelper;
    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestPart(value = "file") MultipartFile file) throws IOException, ServletException {
        return ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file,"imageupload2-ce1e8.appspot.com"));
    }

}
