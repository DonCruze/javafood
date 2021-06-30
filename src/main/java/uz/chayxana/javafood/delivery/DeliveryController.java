package uz.chayxana.javafood.delivery;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.chayxana.javafood.dto.DeliveryRequest;
import uz.chayxana.javafood.dto.OrganizationRequest;

import java.util.List;

@RestController
@RequestMapping("api/v1/organization/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(
            DeliveryService deliveryService
    ) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return deliveryService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody DeliveryRequest req) {
        return deliveryService.add(req);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody DeliveryRequest req) {
        return deliveryService.edit(id, req);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return deliveryService.delete(id);
    }
}
