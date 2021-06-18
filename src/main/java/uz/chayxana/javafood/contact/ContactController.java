package uz.chayxana.javafood.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("organization/{org_id}/contact")
    public ResponseEntity<?> organizationContacts(@PathVariable Long org_id) {
        return contactService.organizationContacts(org_id);
    }

    @GetMapping("contact")
    public ResponseEntity<?> findAll() {
        return contactService.findAll();
    }
}
