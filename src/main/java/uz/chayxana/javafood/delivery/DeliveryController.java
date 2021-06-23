package uz.chayxana.javafood.delivery;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<Delivery> textiles = deliveryService.findAll();
        if (textiles.isEmpty())
            return new ResponseEntity(textiles, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(textiles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Delivery delivery) {
        return deliveryService.add(delivery);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody Delivery delivery) {
        return ResponseEntity.ok(deliveryService.edit(id, delivery));
    }
}
