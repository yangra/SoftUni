package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Supplier;

import java.util.List;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier,Long> {
    List<Supplier> findByImporterFalse();
}
