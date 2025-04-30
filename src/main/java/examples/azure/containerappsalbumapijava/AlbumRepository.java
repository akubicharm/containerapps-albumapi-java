package examples.azure.containerappsalbumapijava;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Integer> {
    // This interface will automatically provide CRUD operations for the Album entity
}