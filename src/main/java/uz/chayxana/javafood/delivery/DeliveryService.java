package uz.chayxana.javafood.delivery;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    private final DeliveryRepo deliveryRepo;

    public DeliveryService(
            DeliveryRepo deliveryRepo
    ) {
        this.deliveryRepo = deliveryRepo;
    }

    public List<uz.chayxana.javafood.delivery.Delivery> findAll() {
        return deliveryRepo.findAll();
    }

    public Optional<uz.chayxana.javafood.delivery.Delivery> findById(Long id) {
        return deliveryRepo.findById(id);
    }


    public  ResponseEntity<?> add(uz.chayxana.javafood.delivery.Delivery delivery) {
        try {
            return new     ResponseEntity(deliveryRepo.save(delivery), HttpStatus.OK);
        } catch (DataIntegrityViolationException divEx) {
            System.out.println(divEx.getMessage());
            return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
        }
    }



    public Delivery edit(Long id, Delivery delivery) {
        Optional<Delivery> deliveryOptional = findById(id);
        if (deliveryOptional.isPresent()) {
            Delivery temp = deliveryOptional.get();
            Optional.ofNullable(delivery.getId()).ifPresent(temp::setId);
            Optional.ofNullable(delivery.getPrice()).ifPresent(temp::setPrice);
            Optional.ofNullable(delivery.getExtraPrice()).ifPresent(temp::setExtraPrice);
            Optional.ofNullable(delivery.getStartTime()).ifPresent(temp::setStartTime);
            Optional.ofNullable(delivery.getEndTime()).ifPresent(temp::setEndTime);
//            Optional.ofNullable(delivery.getOrganization_id()).ifPresent(temp::setOrganization_id);
            return deliveryRepo.save(temp);
        } else {
            return new Delivery();
        }
    }
    
}
