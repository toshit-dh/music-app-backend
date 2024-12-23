package tech.toshitworks.music.dto;

import java.util.List;

public record UserDTO(

    Long id,

    String username,


    String email,


    List<PlaylistDTO> playlist
) {}
