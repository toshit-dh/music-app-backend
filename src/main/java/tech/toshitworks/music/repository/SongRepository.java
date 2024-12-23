package tech.toshitworks.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.toshitworks.music.entity.Song;

public interface SongRepository extends JpaRepository<Song,Long> {
}
