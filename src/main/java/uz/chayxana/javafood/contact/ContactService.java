package uz.chayxana.javafood.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    ContactRepo contactRepo;

    public ResponseEntity<?> organizationContacts(Long orgId) {
        List<Contact> contact = findAllByOrganization(orgId);
        if (!contact.isEmpty()) {
            return new ResponseEntity<>(contact, HttpStatus.OK);
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
}
