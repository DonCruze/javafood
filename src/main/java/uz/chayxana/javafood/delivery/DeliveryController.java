package uz.chayxana.javafood.delivery;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.chayxana.javafood.dto.DeliveryRequest;

@RestController
@RequestMapping("api/v1")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(
            DeliveryService deliveryService
    ) {
        this.deliveryService = deliveryService;
    }

//    @GetMapping("{id}/delivery")
//    public ResponseEntity<?> findAll() {
//        return deliveryService.findAll();
//    }

//    @PostMapping("{id}/delivery")
//    public ResponseEntity<?> add(@RequestBody DeliveryRequest req) {
//        return deliveryService.add(req);
//    }

//    @PutMapping("{id}/delivery/{id}")
//    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody DeliveryRequest req) {
//        return deliveryService.edit(id, req);
//    }

    @DeleteMapping("organization/{org_id}/delivery/{del_id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return deliveryService.delete(id);
    }

    @PostMapping("organization/{org_id}/delivery")
    public ResponseEntity<?> setOrganizationDeliverys(
            @PathVariable(name = "org_id") Long orgId,
            @RequestBody DeliveryRequest req
    ) {
        return deliveryService.setOrganizationDeliveries(orgId, req);
    }

    @PutMapping("organization/{org_id}/delivery/{del_id}")
    public ResponseEntity<?> setOrganizationDeliverys(
            @PathVariable(name = "org_id") Long orgId,
            @RequestBody DeliveryRequest req,
            @PathVariable(name = "del_id") Long delId
    ) {
        return deliveryService.updateOrganizationDeliveries(orgId, req, delId);
    }

    @GetMapping("organization/{org_id}/delivery")
    public ResponseEntity<?> organizationDeliverys(
            @PathVariable(name = "org_id") Long orgId
    ) {
        return deliveryService.getOrganizationDeliveries(orgId);
    }

}
