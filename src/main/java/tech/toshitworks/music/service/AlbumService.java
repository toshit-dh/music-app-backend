package tech.toshitworks.music.service;

import tech.toshitworks.music.dto.AlbumDTO;
import tech.toshitworks.music.dto.ArtistDTO;

import java.util.List;

public interface AlbumService {
    List<AlbumDTO> getAlbumsByArtist(Long artistID);
}
