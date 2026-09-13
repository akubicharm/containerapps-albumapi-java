package examples.azure.containerappsalbumapijava;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * DBまで含めた一気通貫でテストを実施する。
 * AlbumControllerDBTest
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest()
public class AlbumControllerDBTest {
    @Autowired
    private AlbumController albumController;

    private static final String HOME_MESSAGE = "Please visit /albums to see a list of albums.";

    @Test
    public void testHome() throws Exception {
        String result = albumController.home();
        assertEquals(result, HOME_MESSAGE);
    }

    @Test
    public void testGetAllAlbums() throws Exception {
        String json = "{\"id\": 1,\"title\": \"OpenShift Virtualizationサーバ仮想化実践ガイド\",\"artist\": \"石川 純平/大村 真樹\",\"price\": 3080,\"book_url\": \"https://book.impress.co.jp/books/1124101080\",\"image_url\": \"https://img.ips.co.jp/ij/24/1124101080/1124101080-520x.jpg\"}";

        ObjectMapper mapper = new ObjectMapper();
        Album album = mapper.readValue(json, Album.class);

        List<Album> result = albumController.getAllAlbums();
        assertEquals(result.size(), 6);
        assertEquals(result.get(0), album);
        
    }


    @Test
    public void testGetAllAlbumsLocal() throws Exception {
        Album expected = new Album(6, "Sweet Container O' Mine", "Guns N Probeses", 14.99, "https://aka.ms/albums-containerappslogo");

        List<Album> result = albumController.getAllAlbumsLocal();
        assertEquals(result.size(), 6);

        assertEquals(result.get(5), expected);
    }
}