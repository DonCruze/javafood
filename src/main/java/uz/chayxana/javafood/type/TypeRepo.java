package uz.chayxana.javafood.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.organization.Organization;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeRepo extends JpaRepository<Type, Long> {


}
