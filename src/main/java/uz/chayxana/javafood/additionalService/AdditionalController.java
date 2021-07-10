package uz.chayxana.javafood.additionalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.chayxana.javafood.dto.AdditionalRequest;
import uz.chayxana.javafood.dto.DeliveryRequest;

@Api(value = "Additional Service", description = "")
@RestController
@RequestMapping("api/v1/additional-service")
public class AdditionalController {
    @Autowired
    AdditionalService additionalService;

    @GetMapping("additional")
    public ResponseEntity<?> findAll() {
        return additionalService.findAll();
    }

    @GetMapping("organization/{org_id}/additional")
    public ResponseEntity<?> organizationAdditionals(@PathVariable Long org_id) {
        return additionalService.organizationAdditionals(org_id);
    }

    @PostMapping("organization/{org_id}/additional")
    public ResponseEntity<?> add(
            @PathVariable(name = "org_id") Long orgId,
            @RequestBody AdditionalRequest req
    ) {
        return additionalService.add(orgId, req);
    }

    @DeleteMapping("addition/{additional_id}")
    public ResponseEntity<?> delete(
            @PathVariable(name = "additional_id") Long additionalId
    ) {
        return additionalService.delete(additionalId);
    }

    @PutMapping("organization/{org_id}/additional/{additional_id}")
    public ResponseEntity<?> edit(
            @PathVariable(name = "org_id") Long orgId,
            @RequestBody AdditionalRequest req,
            @PathVariable(name = "additional_id") Long additionalId
    ) {
        return additionalService.edit(orgId, req, additionalId);
    }
}

