package uz.chayxana.javafood.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.chayxana.javafood.organization.Organization;

import java.util.List;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Long> {

    List<Menu> findAllByOrganization(Organization organization);
}
