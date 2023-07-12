package com.upload.files.controllers;

import com.upload.files.services.IUploadFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadFilesController {

    @Autowired
    IUploadFilesService uploadFilesService;

    @PostMapping("/picture")
    private ResponseEntity<String> uploadPic(@RequestParam("file") MultipartFile file) throws Exception {
        return new ResponseEntity<>(uploadFilesService.handleFileUpload(file), HttpStatus.OK);
    }
}
