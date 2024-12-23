package tech.toshitworks.music.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Artist{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false)
        private String name;
        private String genre;
        @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
        private List<Album> albums;

}
