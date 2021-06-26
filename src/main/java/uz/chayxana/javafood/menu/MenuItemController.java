package uz.chayxana.javafood.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//haha


@RestController
@RequestMapping("api/v1/Menu")
public class MenuItemController {

    @Autowired
    MenuItemService menuItemService;


//    @GetMapping
//    public ResponseEntity<?> findAll() {
//        List<Menu> textiles = menuService.findAll();
//        if (textiles.isEmpty())
//            return new ResponseEntity(textiles, HttpStatus.BAD_REQUEST);
//        else
//            return new ResponseEntity(textiles, HttpStatus.OK);
//    }
}
