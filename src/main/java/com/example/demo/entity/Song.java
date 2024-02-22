package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;


@Entity
@Table(name = "songs")
@NoArgsConstructor
@ToString
@Getter
public class Song {

    public Song(String artist, String songName) {
        this.artist = artist;
        this.songName = songName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "song_id")
    private UUID songId;

    @Setter
    @Column(name = "artist")
    @NotBlank(message = "Artist must be not blank")
    @Length(min = 2, max = 30)
    private String artist;

    @Setter
    @Column(name = "song_name")
    @NotBlank(message = "Song name must be not blank")
    private String songName;


}
