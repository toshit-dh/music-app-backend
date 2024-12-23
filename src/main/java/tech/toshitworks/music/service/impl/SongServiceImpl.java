package tech.toshitworks.music.service.impl;

import org.springframework.stereotype.Service;
import tech.toshitworks.music.dto.SongDTO;
import tech.toshitworks.music.repository.SongRepository;
import tech.toshitworks.music.service.SongService;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<SongDTO> getSongs() {
        return songRepository.findAll().stream().map((a)->new SongDTO(
                a.getId(),
                a.getTitle(),
                a.getDuration(),
                null,
                null
        )).toList();
    }
}
