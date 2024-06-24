package ectimel.repositories.write;

import ectimel.models.read.PackingListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PackingListWriteJpaRepository extends JpaRepository<PackingListEntity, UUID> {
}
