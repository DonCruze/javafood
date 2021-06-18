package uz.chayxana.javafood.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {
    @Query(value = "select * from contact c where organization_id = :orgId" , nativeQuery = true)
    List<Contact> findAllByOrganization(Long orgId);
}
