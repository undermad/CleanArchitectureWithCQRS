package ectimel.repositories.read;

import ectimel.models.read.PackingListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PackingListJpaRepository extends JpaRepository<PackingListEntity, UUID> {
    
    
    @Query("SELECT pl FROM PackingListEntity pl WHERE pl.name LIKE %:query%")
    List<PackingListEntity> findAllByQuery(String query);
}
