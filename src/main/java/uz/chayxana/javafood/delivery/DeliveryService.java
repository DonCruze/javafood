package uz.chayxana.javafood.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

    public ResponseEntity<?> getOrganizationDeliveries(Long orgId) {
        List<Delivery> deliveries = findAllByOrganization(orgId);
        if (!deliveries.isEmpty()) {
            return new ResponseEntity<>(deliveries, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Delivery is Empty", HttpStatus.BAD_REQUEST);
        }
    }

    private List<Delivery> findAllByOrganization(Long orgId) {
        return deliveryRepo.findAllByOrganization(orgId);
    }

    public ResponseEntity<?> findAll() {
        List<Delivery> delivery = deliveryRepo.findAll();
        if (!delivery.isEmpty()) {
            return new ResponseEntity<>(delivery, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Delivery is Empty", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> setOrganizationDeliveries(Long orgId, DeliveryRequest req) {
        Optional<Organization> organizationOptional = organizationService.findById(orgId);
        if (organizationOptional.isPresent()) {
            return new ResponseEntity(
                    DeliveryResponse.entityToResponse(deliveryRepo.save(Delivery.reqToEntity(req).setOrganization(organizationOptional.get()))),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Deliverys is Empty", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> updateOrganizationDeliveries(Long orgId, DeliveryRequest req,Long delId) {
        Optional<Organization> organizationOptional = organizationService.findById(orgId);
        if (organizationOptional.isPresent()) {
            Optional<Delivery> delivery = deliveryRepo.findByIdAndTrashIsFalse(delId);
            if (delivery.isPresent())
                return new ResponseEntity(
                        DeliveryResponse.entityToResponse(deliveryRepo.save(Delivery.reqToEntity(delivery.get(), req).setOrganization(organizationOptional.get()))),
                        HttpStatus.OK);
            else
            return new ResponseEntity(
                    "Delivery not found",
                    HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Organization not found", HttpStatus.BAD_REQUEST);
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

    public Optional<Delivery> findById(Long id) {
        return deliveryRepo.findById(id);
    }

}























    //    @Autowired
//    DeliveryRepo deliveryRepo;
//    @Autowired
//    OrganizationService organizationService;
//
//    public DeliveryService(
//            DeliveryRepo deliveryRepo
//    ) {
//        this.deliveryRepo = deliveryRepo;
//    }
//
////    public ResponseEntity<?> findAll() {
////        List<?> deliverys = deliveryRepo.findAllByTrashIsFalse()
////                .stream().map(DeliveryResponse::entityToResponse).collect(Collectors.toList());
////        if (deliverys.isEmpty())
////            return new ResponseEntity(deliverys, HttpStatus.BAD_REQUEST);
////        else
////            return new ResponseEntity(deliverys, HttpStatus.OK);
////    }
//
//
//
//
//    public ResponseEntity<?> add(DeliveryRequest req) {
//        try {
//
//            return new ResponseEntity(
//                    DeliveryResponse.entityToResponse(deliveryRepo.save(Delivery.reqToEntity(req)))
//                    , HttpStatus.OK);
//
//        } catch (DataIntegrityViolationException divEx) {
//            System.out.println(divEx.getMessage());
//            return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//            return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//
//    public ResponseEntity<?> edit(Long id, DeliveryRequest req) {
//        Optional<Delivery> deliveryOptional = findById(id);
//        if (deliveryOptional.isPresent()) {
//            try {
//                return new ResponseEntity(
//                        DeliveryResponse.entityToResponse(deliveryRepo.save(Delivery.reqToEntity(deliveryOptional.get(), req)))
//                        , HttpStatus.OK);
//            } catch (DataIntegrityViolationException divEx) {
//                System.out.println(divEx.getMessage());
//                return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage());
//                return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
//            }
//        } else {
//            return new ResponseEntity(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND);
//        }
//    }
//
//
//
//    public ResponseEntity<?> organizationDeliverys(Long orgId) {
//        List<Delivery> deliverys = findAllByOrganization(orgId);
//        Delivery delivery = new Delivery();
//        if (!deliverys.isEmpty()) {
//            return new ResponseEntity<>(deliverys, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Delivery is Empty", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    private List<Delivery> findAllByOrganization(Long orgId) {
//        return deliveryRepo.findAllByOrganization(orgId);
//    }
//}
//
