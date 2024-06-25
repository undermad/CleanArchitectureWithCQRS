package ectimel.repositories.read;

import ectimel.models.read.PackingListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PackingListReadJpaRepository extends JpaRepository<PackingListEntity, UUID> {
    
    
    @Query("SELECT pl FROM PackingListEntity pl WHERE pl.name LIKE %:query%")
    List<PackingListEntity> findAllByQuery(String query);

    @Query("SELECT CASE WHEN COUNT(pl) > 0 THEN TRUE ELSE FALSE END FROM PackingListEntity pl WHERE pl.name = :name")
    Boolean existsByName(@Param("name") String name);
}
