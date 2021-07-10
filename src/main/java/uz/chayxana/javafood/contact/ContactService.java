package uz.chayxana.javafood.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.chayxana.javafood.dto.ContactRequest;
import uz.chayxana.javafood.dto.ContactResponse;
import uz.chayxana.javafood.organization.Organization;
import uz.chayxana.javafood.organization.OrganizationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Autowired
    ContactRepo contactRepo;
    @Autowired
    OrganizationService organizationService;


    public ResponseEntity<?> organizationContacts(Long orgId) {
        Optional<Organization> organizationOptional = organizationService.findByIdOptional(orgId);
        if (organizationOptional.isPresent()) {
            List<Contact> contacts = findAllByOrganization(organizationOptional.get());
            if (!contacts.isEmpty()) {
                return new ResponseEntity<>(
                        contacts.stream().map(ContactResponse::entityToResponse),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>("NOT_FROUND_CONTACTS", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("NOT_FOUND_ORGANIZATION", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> findAll() {
        List<Contact> contact = contactRepo.findAllByTrashIsFalse();
        if (!contact.isEmpty()) {
            return new ResponseEntity<>(
                    contact.stream().map(ContactResponse::entityToResponse),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Contacts is Empty", HttpStatus.BAD_REQUEST);
        }
    }

    private List<Contact> findAllByOrganization(Organization organization) {
        return contactRepo.findAllByTrashIsFalseAndOrganization(organization);
    }

    public Optional<Contact> findById(Long id) {
        return contactRepo.findById(id);
    }

    public ResponseEntity<?> add(Long orgId, ContactRequest req) {
        Optional<Organization> organizationOptional = organizationService.findByIdOptional(orgId);
        if (organizationOptional.isPresent()) {
            return new ResponseEntity(
                    ContactResponse.entityToResponse(contactRepo.save(Contact.dtoToEntity(req).setOrganization(organizationOptional.get()))),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT_FOUND_ORGANIZATION", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> delete(Long id) {
        Optional<Contact> contactOptional = findById(id);

        if (contactOptional.isPresent()) {

            Contact contact = contactOptional.get();
            contact.setTrash(true);
            contactRepo.save(contact);
            return new ResponseEntity("SUCCESS", HttpStatus.OK);

        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND);
        }

    }


    public ResponseEntity<?> edit(Long orgId, ContactRequest req, Long contactId) {
        Optional<Organization> organizationOptional = organizationService.findByIdOptional(orgId);
        if (organizationOptional.isPresent()) {
            Optional<Contact> contact = contactRepo.findByIdAndTrashIsFalse(contactId);
            if (contact.isPresent())
                return new ResponseEntity(
                        ContactResponse.entityToResponse(contactRepo.save(Contact.dtoToEntity(contact.get(),req).setOrganization(organizationOptional.get()))),
                        HttpStatus.OK);
            else
                return new ResponseEntity(
                        "Contact not found",
                        HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Organization not found", HttpStatus.BAD_REQUEST);
        }
    }


}