package com.example.demo.controller;

import com.example.demo.entity.Song;
import com.example.demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/songs")

public class SongController {

    private SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/favourites")
    public List<Song> findAll() {
        return songService.findAll();
    }


    @GetMapping("/favourites/{songId}")
    public Song getSongById(@PathVariable UUID songId) {
        Song song = songService.findById(songId);

        if (song == null) {
            throw new RuntimeException("id not found: " + songId);
        }
        return song;
    }

    @PostMapping("/favourites")
    public Song addSong(@RequestBody Song song) {
        Song dbSong = songService.save(song);
        return dbSong;

    }

    @PutMapping("/favourites")
    public Song updateSong(@RequestBody Song song) {
        Song dbSong = songService.save(song);
        return dbSong;

    }

    @DeleteMapping("/favourites/{songId}")
    public void deleteSongById(@PathVariable UUID songId){
        Song tempSong = songService.findById(songId);

        if (tempSong == null){
            throw new RuntimeException("sorry no such id: " + songId);
        }
        songService.deleteById(songId);
    }
}
