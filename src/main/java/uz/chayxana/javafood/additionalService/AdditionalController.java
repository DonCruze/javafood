package uz.chayxana.javafood.additionalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Additional Service", description = "")
@RestController
@RequestMapping("api/v1/additional-service")
public class AdditionalController {
    @Autowired
    AdditionalService additionalService;

    @ApiOperation(value = "Find All")
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(additionalService.findAll());
    }

    @ApiOperation(value = "Get by One with Id")
    @GetMapping("{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(additionalService.getOne(id));
    }

    @ApiOperation(value = "Add one Service")
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Additional additional) {
        return ResponseEntity.ok(additionalService.add(additional));
    }
}
