package examples.azure.containerappsalbumapijava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class AlbumController {

    private static final Logger logger = LoggerFactory.getLogger(AlbumController.class);

    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        logger.debug("init");
        this.albumRepository = albumRepository;
    }

    @GetMapping("/")
    public String home() {
        logger.info("home");
        return "Please visit /albums to see a list of albums.";
    }

    @GetMapping("/albums")
    List <Album> getAllAlbums() {
        return (List<Album>) albumRepository.findAll();
    }

    @GetMapping("/albumslocal")
    List<Album> getAllAlbumsLocal() {
        return List.of(new Album(1, "You, Me and an App Id", "Daprize", 10.99, "https://aka.ms/albums-daprlogo"),
                new Album(2, "Seven Revision Army", "The Blue-Green Stripes", 13.99, "https://aka.ms/albums-containerappslogo"),
                new Album(3, "Scale It Up", "KEDA Club", 13.99, "https://aka.ms/albums-kedalogo"),
                new Album(4, "Lost in Translation", "MegaDNS", 12.99, "https://aka.ms/albums-envoylogo"),
                new Album(5, "Lock Down Your Love", "V is for VNET", 12.99, "https://aka.ms/albums-vnetlogo"),
                new Album(6, "Sweet Container O' Mine", "Guns N Probeses", 14.99, "https://aka.ms/albums-containerappslogo"));
    }
}
