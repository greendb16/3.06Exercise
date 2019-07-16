package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @RequestMapping("/")
    public String index(Model model){

        Album album = new Album();
        album.setTitle("The Best Album");
        album.setArtist("The You Know Whos");
        album.setGenre("Punk Rock");
        album.setYear(1996);

        Song song=new Song();
        song.setTitle("The Best Song");

        Set<Song> songs = new HashSet<Song>();
        songs.add(song);

        song =new Song();
        song.setTitle("You know the one");
        songs.add(song);

        song= new Song();
        song.setTitle("Everybody Sing Along");
        songs.add(song);

        album.setSongs(songs);
        albumRepository.save(album);

        album = new Album();
        album.setTitle("An O.K. Album");
        album.setArtist("You may have Heard of Us");
        album.setGenre("Modest Rock");
        album.setYear(2011);

        songs=new HashSet<Song>();
        song = new Song();
        song.setTitle("That one song");
        songs.add(song);

        song= new Song();
        song.setTitle("You may have heard of it");
        songs.add(song);

        song = new Song();
        song.setTitle("You Can Sing Along If You Want I Guess");
        songs.add(song);

        album.setSongs(songs);
        albumRepository.save(album);

        model.addAttribute("albums", albumRepository.findAll());
        return "index";
    }

}
