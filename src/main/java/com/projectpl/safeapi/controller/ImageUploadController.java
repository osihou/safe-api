package com.projectpl.safeapi.controller;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.projectpl.safeapi.persistance.entity.ImageTypes;
import com.projectpl.safeapi.service.images.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.PathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.projectpl.safeapi.persistance.entity.ImageModel;

import javax.validation.Valid;


@RestController
public class ImageUploadController {

    public static String uploadDirectory = System.getProperty("user.dir");

    @Autowired
    ImageService imageService;


    @RequestMapping(
            path = "/image/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Iterable<ImageModel> getAllImages(){
        System.out.println(uploadDirectory);
        return imageService.findAll();
    }

    @RequestMapping(
            path = "/image/types",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )public Iterable<ImageTypes> getAllTypes(){
        return Arrays.asList(ImageTypes.values());
    }


    @RequestMapping(
            value = "/image/{type}/{name}",
            method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public ResponseEntity<InputStreamResource> getImage(
            @PathVariable String name,
            @PathVariable String type
    ) throws IOException {

        PathResource imgFile = new PathResource(uploadDirectory+"/uploads/"+type+"/"+name+".jpg");

        //ClassPathResource imgFile  = new ClassPathResource("uploads/"+type+"/"+name+".jpg");

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }


//    @RequestMapping(
//            path = "/eol/image",
//            method = RequestMethod.POST,
//            consumes = { MediaType.APPLICATION_JSON_VALUE,  MediaType.MULTIPART_FORM_DATA_VALUE}
//
//    )
//    public void upploadImageFile(
//            final @RequestParam("file") MultipartFile file
//    ) throws IOException {
//
//        String fileName = file.getOriginalFilename();
//        String filePath = Paths.get(uploadDirectory, fileName).toString();
//        String fileType = file.getContentType();
//        long size = file.getSize();
//        String fileSize = String.valueOf(size);
//
//        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
//        stream.write(file.getBytes());
//        stream.close();
//
//        imageModel.setFileName(fileName);
//        imageModel.setFilePath(filePath);
//        imageModel.setFileSize(fileSize);
//        imageModel.setFileType(fileType);
//
//        imageService.save(imageModel);
//
//    }

    @RequestMapping(
            path = "/eol/image/id/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ImageModel getImageById(
            @PathVariable long id
    ){
        return imageService.findById(id);
    }

    @RequestMapping(
            path = "/eol/image/name/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ImageModel getImageById(
            @PathVariable String name
    ){
        return imageService.findByFileName(name);
    }





}
