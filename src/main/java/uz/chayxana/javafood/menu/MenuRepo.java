package uz.chayxana.javafood.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.chayxana.javafood.contact.Contact;
import uz.chayxana.javafood.organization.Organization;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Long> {

    List<Menu> findAllByTrashIsFalseAndOrganization(Organization organization);

    List<Menu> findAllByTrashIsFalse();

    Optional<Menu> findByIdAndTrashIsFalse(Long id);

}
