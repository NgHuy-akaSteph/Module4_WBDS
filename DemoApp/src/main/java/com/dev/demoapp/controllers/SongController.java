package com.dev.demoapp.controllers;

import com.dev.demoapp.entities.Song;
import com.dev.demoapp.service.UploadFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class SongController {

    private  final static List<String> fileExtensions = new ArrayList<>(List.of("mp3", "wav", "flac", "ogg"));


    @GetMapping("/uploadSong")
    public ModelAndView uploadSong() {
        ModelAndView mav = new ModelAndView("upload_song");
        mav.addObject("song", new Song());
        return mav;
    }

    @PostMapping("/uploadSong")
    public String uploadSong(@ModelAttribute("song") Song song, BindingResult result) {
        if(!fileExtensions.contains(song.getFile().getContentType())){
            result.rejectValue("file", "file.extension", "File extension is not supported");
            return "upload_song";
        }
        UploadFile uploadFile = new UploadFile();
        try {
            uploadFile.uploadFile(song);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "success";
    }

}
