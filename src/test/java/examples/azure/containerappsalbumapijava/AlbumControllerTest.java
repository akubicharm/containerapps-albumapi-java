package examples.azure.containerappsalbumapijava;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AlbumController.class)
public class AlbumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AlbumRepository albumRepository;

    @Test
    public void testGetAllAlbumsLocal() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/albumslocal"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }


    @Test
    public void testHome() throws Exception {
        // Mock the repository data retrieval to return an empty list
        List<Album> albums = Arrays.asList();
        when(albumRepository.findAll()).thenReturn(albums);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Please visit /albums to see a list of albums."));
    }

    @Test
    public void testGetAllAlbums() throws Exception {
        // Setup sample response data
        Album album1 = new Album(1, "OpenShift Virtualizationサーバ仮想化実践ガイド", "石川 純平/大村 真樹", 3080, 
            "https://img.ips.co.jp/ij/24/1124101080/1124101080-520x.jpg", 
            "https://book.impress.co.jp/books/1124101080");
        List<Album> albums = Arrays.asList(album1);

        // Mock the repository to return the sample data
        when(albumRepository.findAll()).thenReturn(albums);

        // Use ObjectMapper to convert ArrayList to JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedJson = objectMapper.writeValueAsString(albums);

        // Perform the GET request and verify the response is correct
        this.mockMvc.perform(MockMvcRequestBuilders.get("/albums")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }
}