package uz.chayxana.javafood.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.chayxana.javafood.contact.Contact;
import uz.chayxana.javafood.organization.Organization;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, Long> {

    List<Delivery> findAllByTrashIsFalse();
    List<Delivery> findAllByTrashIsFalseAndOrganization(Organization organization);

    @Query(value = "select * from delivery c where organization_id = :orgId" , nativeQuery = true)
    List<Delivery> findAllByOrganization(Long orgId);

    // select * from organization where id = :id and trash = false
    Optional<Delivery> findByIdAndTrashIsFalse(Long id);

}
