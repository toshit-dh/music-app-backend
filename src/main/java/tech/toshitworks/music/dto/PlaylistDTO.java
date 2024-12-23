package tech.toshitworks.music.dto;

import java.util.List;

public record PlaylistDTO(

    Long id,


    String name,

    String description,


    List<SongDTO> song,

    UserDTO user
) {}


