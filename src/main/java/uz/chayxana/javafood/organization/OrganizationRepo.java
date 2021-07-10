package uz.chayxana.javafood.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Long> {
  List<Organization> findAllByTrashIsFalse();
  Optional<Organization> findByIdAndTrashIsFalse(Long id);
}
