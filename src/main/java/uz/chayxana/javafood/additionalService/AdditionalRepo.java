package uz.chayxana.javafood.additionalService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.chayxana.javafood.organization.Organization;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdditionalRepo extends JpaRepository<Additional, Long> {

    List<Additional> findAllByTrashIsFalseAndOrganization(Organization organization);

    List<Additional> findAllByTrashIsFalse();

    Optional<Additional> findByIdAndTrashIsFalse(Long id);
}
