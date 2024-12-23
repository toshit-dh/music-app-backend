package tech.toshitworks.music.controller;

import jakarta.annotation.PostConstruct;
import org.reactivestreams.Publisher;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import tech.toshitworks.music.dto.AlbumDTO;
import tech.toshitworks.music.dto.ArtistDTO;
import tech.toshitworks.music.input.ArtistInput;
import tech.toshitworks.music.service.AlbumService;
import tech.toshitworks.music.service.ArtistService;

import java.util.List;

@Controller
public class ArtistController {

    private final ArtistService artistService;
    private final AlbumService albumService;
    private FluxSink<ArtistDTO> addArtistStream;
    private ConnectableFlux<ArtistDTO> addArtistPublisher;

    public ArtistController(ArtistService artistService, AlbumService albumService) {
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @PostConstruct
    public void initSubscription(){
         Flux<ArtistDTO> publisher = Flux.<ArtistDTO>create(e->this.addArtistStream = e);
         addArtistPublisher = publisher.publish();
         addArtistPublisher.connect();
    }


    @QueryMapping
    public List<ArtistDTO> getAllArtists(){
        return artistService.getArtists();
    }

    @QueryMapping
    public ArtistDTO getArtistById(@Argument Long id){
        return artistService.getArtistById(id);
    }

    @SchemaMapping(typeName = "Artist",value = "albums")
    public List<AlbumDTO> getAlbumsByArtist(ArtistDTO artistDTO){
        return albumService.getAlbumsByArtist(artistDTO.id());
    }

    @MutationMapping
    public ArtistDTO createArtist(@Argument ArtistInput artist){
        ArtistDTO artistDTO =  artistService.createArtist(artist);
        addArtistStream.next(artistDTO);
        return artistDTO;
    }

    @SubscriptionMapping
    public Publisher<ArtistDTO> addArtistSubscription(){
        return addArtistPublisher;
    }

}
