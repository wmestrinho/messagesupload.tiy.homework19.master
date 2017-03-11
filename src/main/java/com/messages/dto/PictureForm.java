package com.messages.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by WagnerMestrinho on 3/9/17.
 */
public class PictureForm {
    private long id;
    private MultipartFile pictureFile;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MultipartFile getPictureFile() {
        return pictureFile;
    }

    public void setPictureFile(MultipartFile pictureFile) {
        this.pictureFile = pictureFile;
    }
}

