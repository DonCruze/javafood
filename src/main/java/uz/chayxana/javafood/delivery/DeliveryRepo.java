package uz.chayxana.javafood.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.chayxana.javafood.organization.Organization;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, Long> {

    List<Delivery> findAllByTrashIsFalse();
    List<Delivery> findAllByTrashIsFalseAAndOrganization(Organization organization);

    // select * from organization where id = :id and trash = false
    Optional<Delivery> findByIdAndTrashIsFalse(Long id);

}
