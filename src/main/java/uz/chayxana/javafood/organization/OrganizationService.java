package uz.chayxana.javafood.organization;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.chayxana.javafood.dto.OrganizationRequest;
import uz.chayxana.javafood.dto.OrganizationResponse;
import uz.chayxana.javafood.type.Type;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizationService {
    private final OrganizationRepo organizationRepo;

    public OrganizationService (
            OrganizationRepo organizationRepo
    ) {
        this.organizationRepo = organizationRepo;
    }

    public ResponseEntity<?> findAll() {
        List<?> organizations = organizationRepo.findAllByTrashIsFalse()
                .stream().map(OrganizationResponse::entityToResponse).collect(Collectors.toList());
        if (organizations.isEmpty())
            return new ResponseEntity<>(organizations, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(organizations, HttpStatus.OK);
    }

    public ResponseEntity<?> findById(Long id){
        Optional<Organization> organization = findByIdOptional(id);
        if (organization.isEmpty())
            return new ResponseEntity<>("Empty", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(OrganizationResponse.entityToResponse(organization.get()), HttpStatus.OK);
    }

    public Optional<Organization> findByIdOptional(Long id) { return organizationRepo.findByIdAndTrashIsFalse(id); }

    public ResponseEntity<?> findAllTypes(Long organizationId) {
        Optional<Organization> organizationOptional = findByIdOptional(organizationId);
        if (organizationOptional.isPresent()) {
            List<Type> type = organizationOptional.get().getTypes();
            if (!type.isEmpty()) {
                return new ResponseEntity<>(type, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Type is Empty", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("NOT_FOUND_ORGANIZATION", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> add(OrganizationRequest req) {
        try {
            return new ResponseEntity(
                    OrganizationResponse.entityToResponse(organizationRepo.save(Organization.reqToEntity(req)))
                    , HttpStatus.OK);
        } catch (DataIntegrityViolationException divEx) {
            System.out.println(divEx.getMessage());
            return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> edit(Long id, OrganizationRequest req) {
        Optional<Organization> organizationOptional = findByIdOptional(id);
        if (organizationOptional.isPresent()) {
            try {
                return new ResponseEntity(
                        OrganizationResponse.entityToResponse(organizationRepo.save(Organization.reqToEntity(organizationOptional.get(), req)))
                        , HttpStatus.OK);
            } catch (DataIntegrityViolationException divEx) {
                System.out.println(divEx.getMessage());
                return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> delete(Long id) {
        Optional<Organization> organizationOptional = findByIdOptional(id);
        if (organizationOptional.isPresent()) {
            try {
                Organization organization = organizationOptional.get();
                organization.setTrash(true);
                organizationRepo.save(organization);
                return new ResponseEntity("SUCCESS", HttpStatus.OK);
            } catch (DataIntegrityViolationException divEx) {
                System.out.println(divEx.getMessage());
                StringBuilder relation = new StringBuilder();
                relation.append(!organizationOptional.get().getAddServices().isEmpty() ? "AddServices " : "");
                relation.append(!organizationOptional.get().getContacts().isEmpty() ? "Contact " : "");
                relation.append(!organizationOptional.get().getDeliveries().isEmpty() ? "Delivery " : "");
                relation.append(!organizationOptional.get().getTypes().isEmpty() ? "Types " : "");

                return new ResponseEntity("Est zvyazannie obekti s tablitsami - " + relation, HttpStatus.BAD_REQUEST);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND);
        }
    }

}
