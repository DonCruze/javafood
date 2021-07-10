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
        return contactService.organizationContacts(org_id); }


    @DeleteMapping("contact/{contact_id}")
    public ResponseEntity<?> delete(
            @PathVariable(name = "contact_id") Long contactId
    ) {
        return contactService.delete(contactId);
    }

    @PostMapping("organization/{org_id}/contact")
    public ResponseEntity<?> add(
            @PathVariable(name = "org_id") Long orgId,
            @RequestBody ContactRequest req
    ) {
        return contactService.add(orgId, req);
    }

    @GetMapping("contact")
    public ResponseEntity<?> findAll() {
        return contactService.findAll();
    }

    @PutMapping("organization/{org_id}/contact/{contact_id}")
    public ResponseEntity<?> edit(
            @PathVariable(name = "org_id") Long orgId,
            @RequestBody ContactRequest req,
            @PathVariable(name = "contact_id") Long contactId
    ) {
        return contactService.edit(orgId, req, contactId);
    }

}
