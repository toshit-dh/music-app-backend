package tech.toshitworks.music.service;

import tech.toshitworks.music.dto.ArtistDTO;
import tech.toshitworks.music.input.ArtistInput;

import java.util.List;

public interface ArtistService {

    List<ArtistDTO> getArtists();

    ArtistDTO getArtistById(Long id);

    ArtistDTO createArtist(ArtistInput artistInput);



}
