package com.upload.files.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface IUploadFilesService {
    String handleFileUpload(MultipartFile file) throws Exception;
}
