package uz.chayxana.javafood.organizationMenu;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationMenuService {

    private final OrganizationMenuRepo organizationMenuRepo;

    public OrganizationMenuService(
            OrganizationMenuRepo organizationMenuRepo
    ) {
        this.organizationMenuRepo = organizationMenuRepo;
    }

    public List<uz.chayxana.javafood.organizationMenu.OrganizationMenu> findAll() {
        return organizationMenuRepo.findAll();
    }



    public  ResponseEntity<?> add(uz.chayxana.javafood.organizationMenu.OrganizationMenu organizationMenu) {
        try {
            return new     ResponseEntity(organizationMenuRepo.save(organizationMenu), HttpStatus.OK);
        } catch (DataIntegrityViolationException divEx) {
            System.out.println(divEx.getMessage());
            return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
        }
    }

}
