package uz.chayxana.javafood.organizationMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.chayxana.javafood.delivery.Delivery;

import java.util.List;

@RestController
@RequestMapping("api/v1/OrganizationMenu")
public class OrganizationMenuController {

    @Autowired
    OrganizationMenuService organizationMenuService;


    @GetMapping
    public ResponseEntity<?> findAll() {
        List<OrganizationMenu> textiles = organizationMenuService.findAll();
        if (textiles.isEmpty())
            return new ResponseEntity(textiles, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(textiles, HttpStatus.OK);
    }
}
