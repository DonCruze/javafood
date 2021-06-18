package uz.chayxana.javafood.additionalService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalRepo extends JpaRepository<Additional, Long> {
}
