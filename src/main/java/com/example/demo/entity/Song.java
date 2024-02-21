package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "songs")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column (name = "song_id")
    private UUID songId;

    @Setter
    @Column(name = "artist")
    private String artist;

    @Setter
    @Column(name = "song_name")
    private String songName;


}
