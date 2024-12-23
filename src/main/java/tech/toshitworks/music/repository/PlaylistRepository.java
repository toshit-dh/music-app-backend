package tech.toshitworks.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.toshitworks.music.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
}
