package uz.chayxana.javafood.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.chayxana.javafood.contact.Contact;
import uz.chayxana.javafood.contact.ContactRepo;
import uz.chayxana.javafood.dto.*;
import uz.chayxana.javafood.organization.Organization;
import uz.chayxana.javafood.organization.OrganizationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepo deliveryRepo;
    @Autowired
    OrganizationService organizationService;

    public ResponseEntity<?> findAll() {
        List<Delivery> delivery = deliveryRepo.findAllByTrashIsFalse();
        if (!delivery.isEmpty()) {
            return new ResponseEntity<>(
                    delivery.stream().map(DeliveryResponse::entityToResponse),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Deliveries is Empty", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> organizationDeliveries(Long orgId) {
        Optional<Organization> organizationOptional = organizationService.findByIdOptional(orgId);
        if (organizationOptional.isPresent()) {
            List<Delivery> deliveries = findAllByOrganization(organizationOptional.get());
            if (!deliveries.isEmpty()) {
                return new ResponseEntity<>(
                        deliveries.stream().map(DeliveryResponse::entityToResponse),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>("NOT_FROUND_DELIVERY", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("NOT_FOUND_ORGANIZATION", HttpStatus.BAD_REQUEST);
        }
    }

    private List<Delivery> findAllByOrganization(Organization organization) {
        return deliveryRepo.findAllByTrashIsFalseAndOrganization(organization);
    }

    public Optional<Delivery> findById(Long id) {
        return deliveryRepo.findById(id);
    }

    public ResponseEntity<?> add(Long orgId, DeliveryRequest req) {
        Optional<Organization> organizationOptional = organizationService.findByIdOptional(orgId);
        if (organizationOptional.isPresent()) {
            return new ResponseEntity(
                    DeliveryResponse.entityToResponse(deliveryRepo.save(Delivery.reqToEntity(req).setOrganization(organizationOptional.get()))),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT_FOUND_ORGANIZATION", HttpStatus.NOT_FOUND);
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

    public ResponseEntity<?> edit(Long orgId, DeliveryRequest req, Long deliveryId) {
        Optional<Organization> organizationOptional = organizationService.findByIdOptional(orgId);
        if (organizationOptional.isPresent()) {
            Optional<Delivery> delivery = deliveryRepo.findByIdAndTrashIsFalse(deliveryId);
            if (delivery.isPresent())
                return new ResponseEntity(
                        DeliveryResponse.entityToResponse(deliveryRepo.save(Delivery.reqToEntity(delivery.get(),req).setOrganization(organizationOptional.get()))),
                        HttpStatus.OK);
            else
                return new ResponseEntity(
                        "delivery not found",
                        HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Organization not found", HttpStatus.BAD_REQUEST);
        }
    }

}


