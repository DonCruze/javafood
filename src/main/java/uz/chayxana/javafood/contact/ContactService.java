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

@Service
public class ContactService {
    @Autowired
    ContactRepo contactRepo;
    @Autowired
    OrganizationService organizationService;

    public ResponseEntity<?> organizationContacts(Long orgId) {
        List<Contact> contacts = findAllByOrganization(orgId);
        Contact contact = new Contact();
        if (!contacts.isEmpty()) {
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Contacts is Empty", HttpStatus.BAD_REQUEST);
        }
    }

    private List<Contact> findAllByOrganization(Long orgId) {
        return contactRepo.findAllByOrganization(orgId);
    }

    public ResponseEntity<?> findAll() {
        List<Contact> contact = contactRepo.findAll();
        if (!contact.isEmpty()) {
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Contacts is Empty", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> setOrganizationContacts(Long orgId, ContactRequest req) {
        Optional<Organization> organizationOptional = organizationService.findById(orgId);
        if (organizationOptional.isPresent()) {
            return new ResponseEntity(
                    ContactResponse.entityToResponse(contactRepo.save(Contact.dtoToEntity(req).setOrganization(organizationOptional.get()))),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Contacts is Empty", HttpStatus.BAD_REQUEST);
        }
    }

}
