package uz.chayxana.javafood.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.chayxana.javafood.delivery.Delivery;

import java.util.List;

@Repository
public interface TypeRepo extends JpaRepository<Type, Long> {

    List<Type> findAllByTrashIsFalse();
}
