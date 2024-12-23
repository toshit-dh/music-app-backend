package tech.toshitworks.music.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> songs;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}


