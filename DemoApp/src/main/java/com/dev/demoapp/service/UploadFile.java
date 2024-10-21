package com.dev.demoapp.service;

import com.dev.demoapp.entities.Song;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

@Service
public class UploadFile {

    public void uploadFile(Song song) throws IOException {
        String folder = "H:/C032M4_JV103/Module4_WBDS/DemoApp/src/main/webapp/songs/";
        String fileName = song.getFile().getOriginalFilename();
        FileCopyUtils.copy(song.getFile().getBytes(), new File(folder + fileName));
    }

}
