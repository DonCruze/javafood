package uz.chayxana.javafood.delivery;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.chayxana.javafood.dto.DeliveryRequest;
import uz.chayxana.javafood.dto.DeliveryResponse;
import uz.chayxana.javafood.dto.OrganizationRequest;
import uz.chayxana.javafood.dto.OrganizationResponse;
import uz.chayxana.javafood.organization.Organization;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryService {

    private final DeliveryRepo deliveryRepo;

    public DeliveryService(
            DeliveryRepo deliveryRepo
    ) {
        this.deliveryRepo = deliveryRepo;
    }

    public ResponseEntity<?> findAll() {
        List<?> deliverys = deliveryRepo.findAllByTrashIsFalse()
                .stream().map(DeliveryResponse::entityToResponse).collect(Collectors.toList());
        if (deliverys.isEmpty())
            return new ResponseEntity(deliverys, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(deliverys, HttpStatus.OK);
    }

    public Optional<uz.chayxana.javafood.delivery.Delivery> findById(Long id) {
        return deliveryRepo.findById(id);
    }


    public ResponseEntity<?> add(DeliveryRequest req) {
        try {

            return new ResponseEntity(
                    DeliveryResponse.entityToResponse(deliveryRepo.save(Delivery.reqToEntity(req)))
                    , HttpStatus.OK);

        } catch (DataIntegrityViolationException divEx) {
            System.out.println(divEx.getMessage());
            return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<?> edit(Long id, DeliveryRequest req) {
        Optional<Delivery> deliveryOptional = findById(id);
        if (deliveryOptional.isPresent()) {
            try {
                return new ResponseEntity(
                        DeliveryResponse.entityToResponse(deliveryRepo.save(Delivery.reqToEntity(deliveryOptional.get(), req)))
                        , HttpStatus.OK);
            } catch (DataIntegrityViolationException divEx) {
                System.out.println(divEx.getMessage());
                return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> delete(Long id) {
        Optional<Delivery> deliveryOptional = findById(id);
        if (deliveryOptional.isPresent()) {

            Delivery delivery = deliveryOptional.get();
            delivery.setTrash(true);
            deliveryRepo.save(delivery);
            return new ResponseEntity("SUCCESS", HttpStatus.OK);

        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND);
        }

    }
}

