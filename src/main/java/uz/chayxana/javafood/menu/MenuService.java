package uz.chayxana.javafood.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.chayxana.javafood.contact.Contact;
import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.dto.*;
import uz.chayxana.javafood.organization.Organization;
import uz.chayxana.javafood.organization.OrganizationService;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    MenuRepo menuRepo;
    @Autowired
    OrganizationService organizationService;

    public ResponseEntity<?> findAll() {
        List<Menu> menu = menuRepo.findAllByTrashIsFalse();
        if (!menu.isEmpty()) {
            return new ResponseEntity<>(
                    menu.stream().map(MenuResponse::entityToResponse),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Menues is Empty", HttpStatus.BAD_REQUEST);
        }
    }

    private List<Menu> findAllByOrganization(Organization organization) {
        return menuRepo.findAllByTrashIsFalseAndOrganization(organization);
    }

    public Optional<Menu> findById(Long id) {
        return menuRepo.findById(id);
    }

    public ResponseEntity<?> add(Long orgId, MenuRequest req) {
        Optional<Organization> organizationOptional = organizationService.findByIdOptional(orgId);
        if (organizationOptional.isPresent()) {
            return new ResponseEntity(
                    MenuResponse.entityToResponse(menuRepo.save(Menu.reqToEntity(req).setOrganization(organizationOptional.get()))),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT_FOUND_ORGANIZATION", HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> organizationMenues(Long orgId) {
        Optional<Organization> organizationOptional = organizationService.findByIdOptional(orgId);
        if (organizationOptional.isPresent()) {
            List<Menu> menues = findAllByOrganization(organizationOptional.get());
            if (!menues.isEmpty()) {
                return new ResponseEntity<>(
                        menues.stream().map(MenuResponse::entityToResponse),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>("NOT_FROUND_MENUES", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("NOT_FOUND_ORGANIZATION", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> delete(Long id) {
        Optional<Menu> menuOptional = findById(id);

        if (menuOptional.isPresent()) {

            Menu menu = menuOptional.get();
            menu.setTrash(true);
            menuRepo.save(menu);
            return new ResponseEntity("SUCCESS", HttpStatus.OK);

        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<?> edit(Long orgId, MenuRequest req, Long menuId) {
        Optional<Organization> organizationOptional = organizationService.findByIdOptional(orgId);
        if (organizationOptional.isPresent()) {
            Optional<Menu> menu = menuRepo.findByIdAndTrashIsFalse(menuId);
            if (menu.isPresent())
                return new ResponseEntity(
                        MenuResponse.entityToResponse(menuRepo.save(Menu.reqToEntity(menu.get(),req).setOrganization(organizationOptional.get()))),
                        HttpStatus.OK);
            else
                return new ResponseEntity(
                        "Menu not found",
                        HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Organization not found", HttpStatus.BAD_REQUEST);
        }
    }

}
