package uz.chayxana.javafood.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.chayxana.javafood.organization.Organization;
import uz.chayxana.javafood.organization.OrganizationService;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepo organizationMenuRepo;
    @Autowired
    OrganizationService orgService;

    public ResponseEntity<?> findAll(Long id) {
        Optional<Organization> organizationOptional = orgService.findById(id);
        if (organizationOptional.isPresent()) {
            List<Menu> menu = organizationMenuRepo.findAllByOrganization(organizationOptional.get());
            if (menu.isEmpty())
                return new ResponseEntity("Empty", HttpStatus.BAD_REQUEST);
            else
                return new ResponseEntity(menu, HttpStatus.OK);
        } else {
            return new ResponseEntity("Not found id = " + id + " organization", HttpStatus.NOT_FOUND);
        }
    }

//
//
//    public  ResponseEntity<?> add(uz.chayxana.javafood.organizationMenu.OrganizationMenu organizationMenu) {
//        try {
//            return new     ResponseEntity(organizationMenuRepo.save(organizationMenu), HttpStatus.OK);
//        } catch (DataIntegrityViolationException divEx) {
//            System.out.println(divEx.getMessage());
//            return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//            return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
//        }
//    }

}
