package uz.chayxana.javafood.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.chayxana.javafood.organization.Organization;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {
    List<Contact> findAllByTrashIsFalseAndOrganization(Organization organization);

    List<Contact> findAllByTrashIsFalse();

    Optional<Contact> findByIdAndTrashIsFalse(Long id);
}
