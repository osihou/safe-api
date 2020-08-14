package com.projectpl.safeapi.service.images;

import com.projectpl.safeapi.errors.exceptions.ImageNotFoundException;
import com.projectpl.safeapi.persistance.entity.ImageModel;
import com.projectpl.safeapi.persistance.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class ImageService implements IImageService {


    @Autowired
    ImageRepository imageRepository;

    @Override
    public void save(ImageModel file) throws IOException {

        imageRepository.save(file);
    }



    @Override
    public ImageModel findById(long id) {

        return imageRepository.findById(id)
                .orElseThrow(() -> new ImageNotFoundException(String.valueOf(id)));

    }

    @Override
    public Iterable<ImageModel> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public ImageModel findByFileName(String name) {
        return imageRepository.findByFileName(name)
                .orElseThrow(() -> new ImageNotFoundException(name));
    }


}
