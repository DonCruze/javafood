package uz.chayxana.javafood.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//haha
import java.util.List;


@RestController
@RequestMapping("api/v1/Menu")
public class MenuController {

    @Autowired
    MenuService menuService;


    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Menu> textiles = menuService.findAll();
        if (textiles.isEmpty())
            return new ResponseEntity(textiles, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(textiles, HttpStatus.OK);
    }
}
