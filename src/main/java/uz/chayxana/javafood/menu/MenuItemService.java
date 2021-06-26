package uz.chayxana.javafood.menu;

import org.springframework.stereotype.Service;

@Service
public class MenuItemService {

//    private final MenuRepo menuRepo;
//
//    public MenuService(
//            MenuRepo menuRepo
//    ) {
//        this.menuRepo = menuRepo;
//    }
//
//    public List<Menu> findAll() {
//        return menuRepo.findAll();
//    }
//
//
//
//    public  ResponseEntity<?> add(Menu menu) {
//        try {
//            return new     ResponseEntity(menuRepo.save(menu), HttpStatus.OK);
//        } catch (DataIntegrityViolationException divEx) {
//            System.out.println(divEx.getMessage());
//            return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//            return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
//        }
//    }

}
