package uz.chayxana.javafood.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.chayxana.javafood.delivery.DeliveryService;
import uz.chayxana.javafood.dto.DeliveryRequest;
import uz.chayxana.javafood.dto.TypeRequest;

import java.util.List;

@RestController
@RequestMapping("api/v1/Type")
public class TypeController {

    @Autowired
    TypeService typeService;


    @GetMapping
    public ResponseEntity<?> findAll() {
        return typeService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody TypeRequest req) {
        return typeService.add(req);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody TypeRequest req) {
        return typeService.edit(id, req);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return typeService.delete(id);
    }
}

