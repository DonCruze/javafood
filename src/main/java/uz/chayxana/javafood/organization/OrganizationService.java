package uz.chayxana.javafood.organization;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<?> add(Organization organization) {
        try {
            return new ResponseEntity(organizationRepo.save(organization), HttpStatus.OK);
        } catch (DataIntegrityViolationException divEx) {
            System.out.println(divEx.getMessage());
            return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
        }
    }

    public Organization edit(Long id, Organization organization) {
        Optional<Organization> organizationOptional = findById(id);
        if (organizationOptional.isPresent()) {
            Organization temp = organizationOptional.get();
            Optional.ofNullable(organization.getName()).ifPresent(temp::setName);
            Optional.ofNullable(organization.getStar_time()).ifPresent(temp::setStar_time);
            Optional.ofNullable(organization.getEnd_time()).ifPresent(temp::setEnd_time);
            Optional.ofNullable(organization.getDescription()).ifPresent(temp::setDescription);
            Optional.ofNullable(organization.getLocation()).ifPresent(temp::setLocation);
            Optional.ofNullable(organization.getLogo()).ifPresent(temp::setLogo);
            Optional.ofNullable(organization.getContacts()).ifPresent(temp::setContacts);
//            Optional.ofNullable(organization.getDeliveries()).ifPresent(temp::setDeliveries);
//            Optional.ofNullable(organization.getOrganizationMenus()).ifPresent(temp::setOrganizationMenus);
//            Optional.ofNullable(organization.getTypes()).ifPresent(temp::setTypes);
            return organizationRepo.save(temp);
        } else {
            return new Organization();
        }
    }
}
