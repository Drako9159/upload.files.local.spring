package com.upload.files.services.impl;

import com.upload.files.services.IUploadFilesService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class UploadFilesServiceImpl implements IUploadFilesService {
    @Override
    public String handleFileUpload(MultipartFile file) throws Exception {
        try {
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();
            long fileSize = file.getSize();
            long maxFileSize = 5 * 1024 * 1024;
            if (fileSize > maxFileSize) {
                return "File size must  bet less then or equal 5MG";
            }
            if (!fileOriginalName.endsWith(".jpg") &&
                    !fileOriginalName.endsWith(".jpeg") &&
                    !fileOriginalName.endsWith(".png")) {
                return "Only JPG, JPEG, PNG files are allowed!!";
            }
            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
            String newFileName = fileName + fileExtension;

            File folder = new File("src/main/resources/picture");
            if (!folder.exists()) {
                folder.mkdir();
            }
            Path path = Paths.get("src/main/resources/picture/" + newFileName);
            Files.write(path, bytes);
            return "File upload successfully!!";

        } catch (Exception e) {
            throw new Exception((e.getMessage()));
        }
    }
}
