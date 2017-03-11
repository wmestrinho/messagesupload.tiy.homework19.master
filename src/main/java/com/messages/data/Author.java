package com.messages.data;

/**
 * Created by WagnerMestrinho on 2/9/17.
 */

import com.messages.dto.PictureForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String password;
    private String pictureFileName;
    public Author() {
    }


    public Author(PictureForm dataFromForm, String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }

    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
