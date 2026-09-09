package com.example.filehandling;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    FileEntity uploadFile(MultipartFile file);

    FileEntity getFile(Long id);

    List<FileEntity> getAllFiles();

    void deleteFile(Long id);

}
