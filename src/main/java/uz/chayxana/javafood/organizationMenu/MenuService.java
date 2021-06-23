package uz.chayxana.javafood.organizationMenu;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

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
