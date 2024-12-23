package tech.toshitworks.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.toshitworks.music.entity.Album;
import tech.toshitworks.music.entity.Artist;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album,Long> {

    List<Album> findByArtistId(Long artistID);

}
