package dogbook.controller;

import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dogbook.model.Photo;
import dogbook.service.PhotoService;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class PhotoController {
    @Autowired
    PhotoService photoService;

    @GetMapping("/api/v1/photos/{id}")
    public ResponseEntity<byte[]> getPhotoById(@PathVariable Integer id){
        Optional<Photo> photo = photoService.getPhotoById(id);
        if(photo.isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Picture not found");
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(photo.get().getType()))
                .body(Base64.encodeBase64(photo.get().getData()));
    }
}
