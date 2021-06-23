package uz.chayxana.javafood.organizationMenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationMenuRepo extends JpaRepository<OrganizationMenu, Long> {
}
