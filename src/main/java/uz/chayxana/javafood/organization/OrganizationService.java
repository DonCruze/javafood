package uz.chayxana.javafood.organization;

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

    public Organization add(Organization organization) {
        return organizationRepo.save(organization);
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
            Optional.ofNullable(organization.getDelivery()).ifPresent(temp::setDelivery);
            Optional.ofNullable(organization.getContacts()).ifPresent(temp::setContacts);
            return organizationRepo.save(temp);
        } else {
            return new Organization();
        }
    }
}
