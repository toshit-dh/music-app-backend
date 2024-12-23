package tech.toshitworks.music.service.impl;

import org.springframework.stereotype.Service;
import tech.toshitworks.music.dto.ArtistDTO;
import tech.toshitworks.music.entity.Artist;
import tech.toshitworks.music.exceptions.NoElementException;
import tech.toshitworks.music.input.ArtistInput;
import tech.toshitworks.music.repository.ArtistRepository;
import tech.toshitworks.music.service.AlbumService;
import tech.toshitworks.music.service.ArtistService;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository,AlbumService albumService) {
        this.artistRepository = artistRepository;
    }



    @Override
    public List<ArtistDTO> getArtists() {
        return artistRepository.findAll().stream().map((a)->{
            return new ArtistDTO(
                    a.getId(),
                    a.getName(),
                    a.getGenre(),
                    null
            );
        }).toList();
    }

    @Override
    public ArtistDTO getArtistById(Long id) {
        Artist artist = artistRepository.findById(id).orElseThrow(()-> new NoElementException(
                "Artist",
                "Id",
                id.toString()
        ));
        return new ArtistDTO(
                artist.getId(),
                artist.getName(),
                artist.getGenre(),
                null
        );
    }

    @Override
    public ArtistDTO createArtist(ArtistInput artistInput) {
        Artist artist = new Artist();
        artist.setName(artistInput.getName());
        artist.setGenre(artistInput.getGenre());
        Artist created = artistRepository.save(artist);
        return new ArtistDTO(
                created.getId(),
                created.getName(),
                created.getGenre(),
                null
        );
    }
}
