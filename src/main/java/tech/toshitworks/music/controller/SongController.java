package tech.toshitworks.music.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import tech.toshitworks.music.dto.SongDTO;
import tech.toshitworks.music.service.SongService;

import java.util.List;

@Controller
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @QueryMapping
    public List<SongDTO> getAllSongs(){
        return songService.getSongs();
    }

}
