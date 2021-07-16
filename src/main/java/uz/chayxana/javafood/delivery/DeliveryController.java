package uz.chayxana.javafood.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("organization/{org_id}/delivery")
    public ResponseEntity<?> edit(
            @PathVariable(name = "org_id") Long orgId,
            @RequestBody DeliveryRequest req
    ) {
        return deliveryService.edit(orgId, req);
    }
}
