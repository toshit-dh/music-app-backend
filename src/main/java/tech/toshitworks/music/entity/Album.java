package tech.toshitworks.music.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Album{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false)
        private String releaseDate;

        @ManyToOne
        @JoinColumn(name = "artist_id", nullable = false)
        private Artist artist;

        @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Song> songs;
}
