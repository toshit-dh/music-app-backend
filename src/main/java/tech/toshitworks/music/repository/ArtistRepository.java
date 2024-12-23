package tech.toshitworks.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.toshitworks.music.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist,Long> {

}
