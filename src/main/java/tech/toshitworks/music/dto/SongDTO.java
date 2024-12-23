package tech.toshitworks.music.dto;


public record SongDTO(

    Long id,

    String title,

    String duration,

    AlbumDTO album,

    PlaylistDTO playlist
) {}
