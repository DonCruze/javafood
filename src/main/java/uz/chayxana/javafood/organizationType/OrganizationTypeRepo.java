package uz.chayxana.javafood.organizationType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationTypeRepo extends JpaRepository<OrganizationType, Long> {
}
