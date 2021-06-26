package uz.chayxana.javafood.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.chayxana.javafood.dto.ContactRequest;

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

    @PostMapping("organization/{org_id}/contact")
    public ResponseEntity<?> setOrganizationContacts(@PathVariable Long org_id, @RequestBody ContactRequest req) {
        return contactService.setOrganizationContacts(org_id, req);
    }
}
