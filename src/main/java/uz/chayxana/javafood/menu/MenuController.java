package uz.chayxana.javafood.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/organization")
public class MenuController {

    @Autowired
    MenuService service;

    @GetMapping("{id}/menu")
    public ResponseEntity<?> findAll(@PathVariable Long id) {
        return service.findAll(id);
    }
}