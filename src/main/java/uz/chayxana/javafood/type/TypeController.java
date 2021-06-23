package uz.chayxana.javafood.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/Type")
public class TypeController {

    @Autowired
    TypeService typeService;


    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Type> textiles = typeService.findAll();
        if (textiles.isEmpty())
            return new ResponseEntity(textiles, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(textiles, HttpStatus.OK);
    }
}
