package uz.chayxana.javafood.organization;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.chayxana.javafood.dto.OrganizationRequest;
import uz.chayxana.javafood.dto.TypeRequest;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(
            OrganizationService organizationService
    ) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organization")
    public ResponseEntity findAll() {
        return organizationService.findAll();
    }

    @GetMapping("/organization/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return organizationService.findById(id);
    }

    @GetMapping("/{organization_id}/type")
    public ResponseEntity<?> findAllTypes(
            @PathVariable(name = "organization_id") Long organizationId
    ) {
        return organizationService.findAllTypes(organizationId);
    }

    @PostMapping("/{organization_id}/type")
    public ResponseEntity<?> addTypesInOrganization(
            @PathVariable(name = "organization_id") Long organizationId,
            @RequestBody List<TypeRequest> typeForms
    ) {
        return organizationService.addTypesInOrganization(organizationId, typeForms);
    }

    @DeleteMapping("/{organization_id}/type/{type_id}")
    public ResponseEntity<?> deleteTypesInOrganization(
            @PathVariable(name = "organization_id") Long organizationId,
            @PathVariable(name = "type_id") Long typeId
    ) {
        return organizationService.deleteTypesInOrganization(organizationId, typeId);
    }

    @PostMapping("/organization")
    public ResponseEntity<?> add(@RequestBody OrganizationRequest req) {
        return organizationService.add(req);
    }

    @PutMapping("organization/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody OrganizationRequest req) {
        return organizationService.edit(id, req);
    }

    @DeleteMapping("organization/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return organizationService.delete(id);
    }
}
