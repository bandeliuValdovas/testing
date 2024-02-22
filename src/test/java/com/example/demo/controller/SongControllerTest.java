package com.example.demo.controller;


import com.example.demo.entity.Song;
import com.example.demo.service.SongServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(SongController.class)
public class SongControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SongServiceImpl songService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void shouldFindAllSongs() throws Exception {
        var testSongs = List.of(
                new Song("name", "songname"),
                new Song("artist", "sing2"));

        Mockito.when(songService.findAll()).thenReturn(testSongs);
        mockMvc.perform(get("/songs/favourites"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(testSongs)));
        log.info(objectMapper.writeValueAsString(testSongs));

    }

}
