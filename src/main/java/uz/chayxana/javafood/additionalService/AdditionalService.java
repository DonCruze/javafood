package uz.chayxana.javafood.additionalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.dto.AdditionalRequest;
import uz.chayxana.javafood.dto.AdditionalResponse;
import uz.chayxana.javafood.dto.DeliveryRequest;
import uz.chayxana.javafood.dto.DeliveryResponse;
import uz.chayxana.javafood.organization.Organization;
import uz.chayxana.javafood.organization.OrganizationService;

import java.util.List;
import java.util.Optional;

@Service
public class AdditionalService {
    @Autowired
    AdditionalRepo additionalRepo;

    @Autowired
    OrganizationService organizationService;

    public ResponseEntity<?> findAll() {
        List<Additional> additional = additionalRepo.findAllByTrashIsFalse();
        if (!additional.isEmpty()) {
            return new ResponseEntity<>(
                    additional.stream().map(AdditionalResponse::entityToResponse),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Additionals is Empty", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> organizationAdditionals(Long orgId) {
        Optional<Organization> organizationOptional = organizationService.findByIdOptional(orgId);
        if (organizationOptional.isPresent()) {
            List<Additional> additionals = findAllByOrganization(organizationOptional.get());
            if (!additionals.isEmpty()) {
                return new ResponseEntity<>(
                        additionals.stream().map(AdditionalResponse::entityToResponse),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>("NOT_FROUND_ADDITIONALS", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("NOT_FOUND_ORGANIZATION", HttpStatus.BAD_REQUEST);
        }
    }

    private List<Additional> findAllByOrganization(Organization organization) {
        return additionalRepo.findAllByTrashIsFalseAndOrganization(organization);
    }

    public Optional<Additional> findById(Long id) {
        return additionalRepo.findById(id);
    }

    public ResponseEntity<?> add(Long orgId, AdditionalRequest req) {
        Optional<Organization> organizationOptional = organizationService.findByIdOptional(orgId);
        if (organizationOptional.isPresent()) {
            return new ResponseEntity(
                    AdditionalResponse.entityToResponse(additionalRepo.save(Additional.dtoToEntity(req).setOrganization(organizationOptional.get()))),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT_FOUND_ORGANIZATION", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> delete(Long id) {
        Optional<Additional> additionalOptional = findById(id);

        if (additionalOptional.isPresent()) {

            Additional additional = additionalOptional.get();
            additional.setTrash(true);
            additionalRepo.save(additional);
            return new ResponseEntity("SUCCESS", HttpStatus.OK);

        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<?> edit(Long orgId, AdditionalRequest req, Long additionalId) {
        Optional<Organization> organizationOptional = organizationService.findByIdOptional(orgId);
        if (organizationOptional.isPresent()) {
            Optional<Additional> additional = additionalRepo.findByIdAndTrashIsFalse(additionalId);
            if (additional.isPresent())
                return new ResponseEntity(
                        AdditionalResponse.entityToResponse(additionalRepo.save(Additional.dtoToEntity(additional.get(),req).setOrganization(organizationOptional.get()))),
                        HttpStatus.OK);
            else
                return new ResponseEntity(
                        "additional not found",
                        HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Organization not found", HttpStatus.BAD_REQUEST);
        }
    }
}
