package com.example.filehandling;

import java.util.List;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    // ==========================================
    // HOME PAGE
    // ==========================================

    @GetMapping
    public String showFiles(Model model) {

        List<FileEntity> files =
                fileService.getAllFiles();

        model.addAttribute("files", files);

        return "files";
    }


    // ==========================================
    // UPLOAD
    // ==========================================

    @PostMapping("/upload")
    public String uploadFile(
            @RequestParam("uploadingFiles") MultipartFile file,
            Model model) {

        try {

            fileService.uploadFile(file);

            return "redirect:/files";

        } catch (RuntimeException e) {

            model.addAttribute(
                    "errorMessage",
                    e.getMessage()
            );

            model.addAttribute(
                    "files",
                    fileService.getAllFiles()
            );

            return "files";
        }
    }



    // ==========================================
    // DOWNLOAD
    // ==========================================

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(
            @PathVariable Long id) {

        FileEntity file =
                fileService.getFile(id);

        HttpHeaders headers =
                new HttpHeaders();

        headers.setContentType(
                MediaType.parseMediaType(
                        file.getFileType()
                )
        );

        ContentDisposition contentDisposition =
                ContentDisposition
                        .attachment()
                        .filename(file.getFileName())
                        .build();

        headers.setContentDisposition(
                contentDisposition
        );

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(file.getFileData());
    }


    // ==========================================
    // VIEW / PLAY FILE
    // ==========================================

    @GetMapping("/view/{id}")
    public ResponseEntity<byte[]> viewFile(
            @PathVariable Long id) {

        FileEntity file =
                fileService.getFile(id);

        HttpHeaders headers =
                new HttpHeaders();

        headers.setContentType(
                MediaType.parseMediaType(
                        file.getFileType()
                )
        );

        ContentDisposition contentDisposition =
                ContentDisposition
                        .inline()
                        .filename(file.getFileName())
                        .build();

        headers.setContentDisposition(
                contentDisposition
        );

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(file.getFileData());
    }


    // ==========================================
    // DELETE
    // ==========================================

    @PostMapping("/delete/{id}")
    public String deleteFile(
            @PathVariable Long id) {

        fileService.deleteFile(id);

        return "redirect:/files";
    }
}

