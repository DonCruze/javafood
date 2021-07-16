package uz.chayxana.javafood.organization;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.chayxana.javafood.dto.OrganizationRequest;
import uz.chayxana.javafood.dto.OrganizationResponse;
import uz.chayxana.javafood.dto.TypeRequest;
import uz.chayxana.javafood.type.Type;
import uz.chayxana.javafood.type.TypeRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrganizationService {
    private final OrganizationRepo organizationRepo;
    private final TypeRepo typeRepo;

    public OrganizationService(
            OrganizationRepo organizationRepo,
            TypeRepo typeRepo) {
        this.organizationRepo = organizationRepo;
        this.typeRepo = typeRepo;
    }

    public ResponseEntity<?> findAll() {
        List<?> organizations = organizationRepo.findAllByTrashIsFalse()
                .stream().map(OrganizationResponse::entityToResponse).collect(Collectors.toList());
        if (organizations.isEmpty())
            return new ResponseEntity<>(organizations, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(organizations, HttpStatus.OK);
    }

    public ResponseEntity<?> findById(Long id) {
        Optional<Organization> organization = findByIdOptional(id);
        if (organization.isEmpty())
            return new ResponseEntity<>("Empty", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(OrganizationResponse.entityToResponse(organization.get()), HttpStatus.OK);
    }

    public Optional<Organization> findByIdOptional(Long id) {
        return organizationRepo.findByIdAndTrashIsFalse(id);
    }

    public ResponseEntity<?> findAllTypes(Long organizationId) {
        Optional<Organization> organizationOptional = findByIdOptional(organizationId);
        if (organizationOptional.isPresent()) {
            Set<Type> type = organizationOptional.get().getTypes();
            if (!type.isEmpty()) {
                return new ResponseEntity<>(type, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Type is Empty", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("NOT_FOUND_ORGANIZATION", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> addTypesInOrganization(Long organizationID, List<TypeRequest> typeForms) {
        Optional<Organization> organizationOptional = findByIdOptional(organizationID);
        if (organizationOptional.isEmpty()) {
            return new ResponseEntity("Ne nashol Organization", HttpStatus.BAD_REQUEST);
        }

        try {
            Set<Type> typeSet = new HashSet<>(typeRepo.saveAll(typeForms.stream().map(Type::reqToEntity).collect(Collectors.toSet())));
            organizationOptional.get().getTypes().addAll(typeSet);
            return new ResponseEntity(
                    OrganizationResponse.entityToResponse(organizationRepo.save(organizationOptional.get()))
                    , HttpStatus.OK);
        } catch (DataIntegrityViolationException divEx) {
            System.out.println(divEx.getMessage());
            return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> deleteTypesInOrganization(Long organizationID, Long typeID) {
        Optional<Organization> organizationOptional = findByIdOptional(organizationID);
        if (organizationOptional.isEmpty()) {
            return new ResponseEntity("Ne nashol Organization", HttpStatus.BAD_REQUEST);
        }
        Optional<Type> typeOptional = typeRepo.findByIdAndTrashIsFalse(typeID);
        if (typeOptional.isEmpty()) {
            return new ResponseEntity("Ne nashol Type", HttpStatus.BAD_REQUEST);
        }

        boolean state = false;
        for (Type type : organizationOptional.get().getTypes()) {
            if (type.getId().equals(typeID)) {
                state = true;
            }
        }
        if (!state) {
            return new ResponseEntity("Ne nashol Type", HttpStatus.BAD_REQUEST);
        }
        try {
            organizationOptional.get().getTypes().remove(typeOptional.get());
            return new ResponseEntity(
                    OrganizationResponse.entityToResponse(organizationRepo.save(organizationOptional.get()))
                    , HttpStatus.OK);
        } catch (DataIntegrityViolationException divEx) {
            System.out.println(divEx.getMessage());
            return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
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
                organization.getDelivery().setTrash(true);
                organizationRepo.save(organization);
                return new ResponseEntity("SUCCESS", HttpStatus.OK);
            } catch (DataIntegrityViolationException divEx) {
                System.out.println(divEx.getMessage());
                StringBuilder relation = new StringBuilder();
                relation.append(!organizationOptional.get().getAddServices().isEmpty() ? "AddServices " : "");
                relation.append(!organizationOptional.get().getContacts().isEmpty() ? "Contact " : "");
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
