package tech.toshitworks.music.service.impl;

import org.springframework.stereotype.Service;
import tech.toshitworks.music.dto.AlbumDTO;
import tech.toshitworks.music.repository.AlbumRepository;
import tech.toshitworks.music.service.AlbumService;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<AlbumDTO> getAlbumsByArtist(Long artistID) {
        return albumRepository.findByArtistId(artistID).stream().map((al) ->
                new AlbumDTO(
                        al.getId(),
                        al.getTitle(),
                        al.getReleaseDate()
                )).toList();
    }
}
