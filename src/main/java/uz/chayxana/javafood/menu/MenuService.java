package uz.chayxana.javafood.menu;

import org.springframework.stereotype.Service;

@Service
public class MenuService {

//    private final OrganizationMenuRepo organizationMenuRepo;
//
//    public OrganizationMenuService(
//            OrganizationMenuRepo organizationMenuRepo
//    ) {
//        this.organizationMenuRepo = organizationMenuRepo;
//    }
//
//    public List<uz.chayxana.javafood.organizationMenu.OrganizationMenu> findAll() {
//        return organizationMenuRepo.findAll();
//    }
//
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
