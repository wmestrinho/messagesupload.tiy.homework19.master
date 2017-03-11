package com.messages.controller;

import com.messages.data.Author;
import com.messages.data.Messages;
import com.messages.repository.MessagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Calendar;

/**
 * Created by WagnerMestrinho on 2/9/17.
 */
@Controller
public class MessagesController {

    @Autowired
    MessagesRepo messagesRepo;

    @RequestMapping(path = "/secure/write", method = RequestMethod.POST)
    public String createMessage(Model dataToJsp, HttpSession session,
                                @RequestParam String content){

        // same as one-liner below
        //
        //      Object userAsObject = session.getAttribute("user");
        //        Author anAuthor = (Author)userAsObject;
        //        String userName = anAuthor.getName();

        Author author = (Author)session.getAttribute("user");
        Messages tmp = new Messages(content, author);
        tmp.setTime(Calendar.getInstance().getTime());

        messagesRepo.save(tmp);
        //if saved add message
        if(tmp.getId()>0) {
            dataToJsp.addAttribute("msg_success",
                    String.format( "%s you're Great" , author));
        }
        return "forward:/secure/messages";
    }

    @RequestMapping(path = "/secure/messages")
    public String listMessages(Model xyz){
        String destination = "/secure/wall";
        Iterable found = messagesRepo.findAll();
        // put list into model
        xyz.addAttribute("mList", found);
        // go to jsp
        return destination;
    }
}
