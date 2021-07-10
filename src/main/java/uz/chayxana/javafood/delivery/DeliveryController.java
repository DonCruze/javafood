package uz.chayxana.javafood.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.chayxana.javafood.dto.ContactRequest;
import uz.chayxana.javafood.dto.DeliveryRequest;

@RestController
@RequestMapping("api/v1")
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @GetMapping("delivery")
    public ResponseEntity<?> findAll() {
        return deliveryService.findAll();
    }

    @GetMapping("organization/{org_id}/delivery")
    public ResponseEntity<?> organizationDeliveries(@PathVariable Long org_id) {
        return deliveryService.organizationDeliveries(org_id);
    }

    @PostMapping("organization/{org_id}/delivery")
    public ResponseEntity<?> add(
            @PathVariable(name = "org_id") Long orgId,
            @RequestBody DeliveryRequest req
    ) {
        return deliveryService.add(orgId, req);
    }

    @DeleteMapping("delivery/{delivery_id}")
    public ResponseEntity<?> delete(
            @PathVariable(name = "delivery_id") Long deliveryId
    ) {
        return deliveryService.delete(deliveryId);
    }

    @PutMapping("organization/{org_id}/delivery/{delivery_id}")
    public ResponseEntity<?> edit(
            @PathVariable(name = "org_id") Long orgId,
            @RequestBody DeliveryRequest req,
            @PathVariable(name = "delivery_id") Long deliveryId
    ) {
        return deliveryService.edit(orgId, req, deliveryId);
    }
}
