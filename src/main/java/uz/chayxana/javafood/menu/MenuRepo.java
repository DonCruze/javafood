package uz.chayxana.javafood.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.chayxana.javafood.organization.Organization;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Long> {


}
