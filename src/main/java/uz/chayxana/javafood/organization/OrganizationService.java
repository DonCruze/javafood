package uz.chayxana.javafood.organization;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.chayxana.javafood.dto.OrganizationRequest;
import uz.chayxana.javafood.dto.OrganizationResponse;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
    private final OrganizationRepo organizationRepo;

    public OrganizationService(
            OrganizationRepo organizationRepo
    ) {
        this.organizationRepo = organizationRepo;
    }

    public List<Organization> findAll() {
        return organizationRepo.findAll();
    }

    public Optional<Organization> findById(Long id) {
        return organizationRepo.findById(id);
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
        Optional<Organization> organizationOptional = findById(id);
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
}
