package com.messages.controller;

import com.messages.data.Author;
import com.messages.dto.PictureForm;
import com.messages.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by WagnerMestrinho on 3/9/17.
 */
@Controller
public class PictureController {
    @Autowired
    AuthorRepo pictureRepo;

    @Value("${upload.location}")
    private String uploadLocation;

    @RequestMapping(path = "/wall/delete", method = RequestMethod.GET)
    public String deleteMovie(Model mapOfDataForJsp, @RequestParam Long id){
        pictureRepo.delete(id);
        // find by
        mapOfDataForJsp.addAttribute("success_msg", "Picture Deleted.");
        return "forward:/secure/wall";
    }

    @RequestMapping(path = "/secure/posting", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE)
    public String createPost(Model dataToJsp, HttpSession session, PictureForm myFavoritePic) throws Exception {
        String dest = "/secure/wall";

        Author author = null;
        // only do copy work if local file was uploaded
        if (!myFavoritePic.getPictureFile().getOriginalFilename().isEmpty()) {
            String uploadedFileName = System.currentTimeMillis() + "_" + myFavoritePic.getPictureFile().getOriginalFilename();
            // copy from input stream to computer disk
            Files.copy(myFavoritePic.getPictureFile().getInputStream(), Paths.get(uploadLocation + uploadedFileName));
            author = (Author)session.getAttribute("user");
            author.setPictureFileName(uploadedFileName);
           pictureRepo.save(author);
        }
       /* else {
            // no copy work, could be edit or just new with poster URL
            saveToDB = new Author(myFavoritePic);
            // we need to re-fetch poster file name (local file name) if this
            // is an edit AND they have not provided a poster URL
            if (saveToDB.getId() != 0 &&
                    (saveToDB.getPictureUrl() == null || saveToDB.getPictureUrl().isEmpty())) {
                // need to ensure uploaded file name is not overridden
                Author tmp = pictureRepo.findOne(saveToDB.getId());
                saveToDB.setPictureFileName(tmp.getPictureFileName());*/

        // save to database

        // if successful save, add message
        if(author.getId()!=0) {
            dataToJsp.addAttribute("up_load", "Image Added");
        }
        /*@RequestMapping(path = "/secure/movies")
        public String listMovies(Model xyz){
            String destination = "home";
            Iterable found = messagesRepo.findAll();
            // put list into model
            xyz.addAttribute("mList", found);*/
        return dest;
        //TODO put it into a list
    }
}