package uz.chayxana.javafood.organization;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.chayxana.javafood.dto.OrganizationRequest;

@RestController
@RequestMapping("api/v1/organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(
            OrganizationService organizationService
    ) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return organizationService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findAllById(@PathVariable Long id) {
        return organizationService.findAllById(id);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody OrganizationRequest req) {
        return organizationService.add(req);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody OrganizationRequest req) {
        return organizationService.edit(id, req);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return organizationService.delete(id);
    }
}
