package examples.azure.containerappsalbumapijava;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AlbumTest {

    private static int al1Id = 1;
    private static String al1Title = "New Title";
    private static String al1Artist = "New Atist";
    private static double al1Price = 29.99;
    private static String al1Image = "http://new.image.url";
    private static String al1Url = "http://new.book.url";

    private static int al2Id = 2;

    @Test
    public void testConstructors() {
        // Test no-arg constructor
        Album album = new Album();
        assertNotNull(album);
        assertEquals(0, album.getId());
        assertNull(album.getTitle());
        assertNull(album.getArtist());
        assertEquals(0.0, album.getPrice(), 0.001);
        assertNull(album.getImage_url());
        assertNull(album.getBook_url());
    }


    @Test
    public void testConsutructorsWithoutUrl() {

        // Test 5-arg constructor
        Album album = new Album(al1Id, al1Title, al1Artist, al1Price, al1Image);
        assertEquals(al1Id, album.getId());
        assertEquals(al1Title, album.getTitle());
        assertEquals(al1Artist, album.getArtist());
        assertEquals(al1Price, album.getPrice(), 0.001);
        assertEquals(al1Image, album.getImage_url());
        assertNull(album.getBook_url());


        assertThrows(IllegalArgumentException.class, () -> {new Album(al1Id, al1Title, al1Artist, -1, al1Image);});

    }

    @Test
    public void testConsutouctorsWithUrl() {
        // Test 6-arg constructor
        Album album = new Album(al1Id, al1Title, al1Artist, al1Price, al1Image, al1Url);
        assertEquals(al1Id, album.getId());
        assertEquals(al1Title, album.getTitle());
        assertEquals(al1Artist, album.getArtist());
        assertEquals(al1Price, album.getPrice(), 0.001);
        assertEquals(al1Image, album.getImage_url());
        assertEquals(al1Url, album.getBook_url()); 

        Exception expected = assertThrows(IllegalArgumentException.class, () -> {new Album(al1Id, al1Title, al1Artist, -1.0, al1Image, al1Url);});
        assertEquals(expected.getMessage(), "The value is negative.");

    }

    @Test
    public void testGetter() {
        Album album = new Album(al1Id, al1Title, al1Artist, al1Price, al1Image, al1Url);

        // Test getters
        assertEquals(al1Id, album.getId());
        assertEquals(al1Title, album.getTitle());
        assertEquals(al1Artist, album.getArtist());
        assertEquals(al1Price, album.getPrice(), 0.001);
        assertEquals(al1Image, album.getImage_url());
        assertEquals(al1Url, album.getBook_url());
    }

    @Test
    public void setSetter() {
        Album album = new Album();
        album.setId(al1Id);
        album.setTitle(al1Title);
        album.setArtist(al1Artist);
        album.setPrice(al1Price);
        album.setImage_url(al1Image);
        album.setBook_url(al1Url);

        assertEquals(al1Id, album.getId());
        assertEquals(al1Title, album.getTitle());
        assertEquals(al1Artist, album.getArtist());
        assertEquals(al1Price, album.getPrice(), 0.001);
        assertEquals(al1Image, album.getImage_url());
        assertEquals(al1Url, album.getBook_url());

        assertThrows(IllegalArgumentException.class, () -> {new Album(al1Id, al1Title, al1Artist, -1, al1Image);});            
    }

    @Test
    public void testEquals() {
        Album album = new Album();
        Album albumNull = null;
        String notAlbum = new String();
        Album album11 = new Album(al1Id, al1Title, al1Artist, al1Price, al1Image);
        Album album12 = new Album(al2Id, al1Title, al1Artist, al1Price, al1Image);

        Album album21 = new Album(al1Id, al1Title, al1Artist, al1Price, al1Image, al1Url);
        Album album22 = new Album(al2Id, al1Title, al1Artist, al1Price, al1Image, al1Url);

  
        assertFalse(album.equals(albumNull));
        assertFalse(album.equals(album11));
        assertFalse(album.equals(notAlbum));
    
        assertFalse(album11.equals(album12));
        assertTrue(album11.equals(album21));
        assertFalse(album11.equals(album22));
    }

    @Test
    public void testHashCode() {
        Album album1 = new Album();
        Album album2 = new Album(al1Id, al1Title, al1Artist, al1Price, al1Image, al1Url);

        assertEquals(0, album1.hashCode());
        assertEquals(1, album2.hashCode());
    }
}