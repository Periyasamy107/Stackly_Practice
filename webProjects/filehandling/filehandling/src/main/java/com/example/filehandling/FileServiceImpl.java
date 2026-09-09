package com.example.filehandling;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FileServiceImpl implements FileService{

    private final FileRepository fileRepository;

    // ==========================================
    // ALLOWED FILE EXTENSIONS
    // ==========================================

    private static final Set<String> ALLOWED_EXTENSIONS =
            new HashSet<>(Arrays.asList(

                    "txt",

                    "pdf",

                    "doc",
                    "docx",

                    "xls",
                    "xlsx",

                    "png",
                    "jpg",
                    "jpeg",

                    "mp3",
                    "wav",

                    "mp4",
                    "webm"

            ));


    public FileServiceImpl(FileRepository fileRepository) {

        this.fileRepository = fileRepository;
    }


    // ==========================================
    // UPLOAD FILE
    // ==========================================

    @Override
    public FileEntity uploadFile(MultipartFile file) {

        // --------------------------------------
        // 1. Check whether file exists
        // --------------------------------------

        if (file == null || file.isEmpty()) {

            throw new RuntimeException(
                    "Please select a file to upload."
            );
        }


        // --------------------------------------
        // 2. Get original filename
        // --------------------------------------

        String fileName =
                file.getOriginalFilename();


        if (fileName == null || fileName.isBlank()) {

            throw new RuntimeException(
                    "Invalid file name."
            );
        }


        // --------------------------------------
        // 3. Extract extension
        // --------------------------------------

        String extension =
                getFileExtension(fileName);


        // --------------------------------------
        // 4. Validate extension
        // --------------------------------------

        if (extension.isEmpty()) {
            throw new RuntimeException(
                    "File must have a supported extension."
            );
        }

        if (!ALLOWED_EXTENSIONS.contains(extension)) {

            throw new RuntimeException(
                    "File format ." + extension
                            + " is not supported. "
                            + "Allowed formats are: "
                            + String.join(
                            ", ",
                            ALLOWED_EXTENSIONS
                    )
            );
        }


        // --------------------------------------
        // 5. Get content type
        // --------------------------------------

        String contentType =
                file.getContentType();


        // --------------------------------------
        // 6. Read file data
        // --------------------------------------

        try {

            byte[] fileData =
                    file.getBytes();


            // ----------------------------------
            // 7. Create Entity
            // ----------------------------------

            FileEntity fileEntity =
                    new FileEntity();

            fileEntity.setFileName(fileName);

            fileEntity.setFileType(contentType);

            fileEntity.setFileSize(
                    file.getSize()
            );

            fileEntity.setFileData(fileData);


            // ----------------------------------
            // 8. Save to database
            // ----------------------------------

            return fileRepository.save(
                    fileEntity
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to read the uploaded file."
            );
        }
    }


    // ==========================================
    // GET FILE
    // ==========================================

    @Override
    public FileEntity getFile(Long id) {

        return fileRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "File not found with id: " + id
                        )
                );
    }


    // ==========================================
    // GET ALL FILES
    // ==========================================

    @Override
    public List<FileEntity> getAllFiles() {

        return fileRepository.findAll();
    }


    // ==========================================
    // DELETE FILE
    // ==========================================

    @Override
    public void deleteFile(Long id) {

        if (!fileRepository.existsById(id)) {

            throw new RuntimeException(
                    "File not found with id: " + id
            );
        }

        fileRepository.deleteById(id);
    }


    // ==========================================
    // GET FILE EXTENSION
    // ==========================================

    private String getFileExtension(
            String fileName) {

        int lastDot =
                fileName.lastIndexOf('.');


        if (lastDot == -1 ||
                lastDot == fileName.length() - 1) {

            return "";
        }


        return fileName
                .substring(lastDot + 1)
                .toLowerCase();
    }
}
