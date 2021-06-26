package uz.chayxana.javafood.organization;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.chayxana.javafood.dto.OrganizationRequest;

import java.util.List;

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
        List<Organization> textiles = organizationService.findAll();
        if (textiles.isEmpty())
            return new ResponseEntity(textiles, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(textiles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody OrganizationRequest req) {
        return organizationService.add(req);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody OrganizationRequest req) {
        return organizationService.edit(id, req);
    }

}
