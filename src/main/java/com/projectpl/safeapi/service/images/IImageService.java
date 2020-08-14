package com.projectpl.safeapi.service.images;

import com.projectpl.safeapi.persistance.entity.ImageModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImageService {
    void save(ImageModel file) throws IOException;

    ImageModel findById(long id);

    Iterable<ImageModel> findAll();

    ImageModel findByFileName(String name);
}
