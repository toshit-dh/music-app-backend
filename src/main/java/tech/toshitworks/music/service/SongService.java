package tech.toshitworks.music.service;

import tech.toshitworks.music.dto.SongDTO;

import java.util.List;

public interface SongService {

    List<SongDTO> getSongs();

}
