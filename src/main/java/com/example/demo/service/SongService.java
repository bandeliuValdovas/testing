package com.example.demo.service;

import com.example.demo.entity.Song;

import java.util.List;
import java.util.UUID;

public interface SongService {
    List<Song>findAll();
    Song findById(UUID uuid);
    Song save(Song song);
    void deleteById(UUID uuid);
}
