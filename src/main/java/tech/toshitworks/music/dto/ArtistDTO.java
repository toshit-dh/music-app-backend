package tech.toshitworks.music.dto;


import java.util.List;

public record ArtistDTO (
    Long id,
    String name,
    String genre,
    List<AlbumDTO> albums
){}
