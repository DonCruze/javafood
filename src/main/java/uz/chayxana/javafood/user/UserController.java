package uz.chayxana.javafood.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {
   @Autowired
   UserService userService;

    @GetMapping("user")
    public ResponseEntity<?> findall(){

        return  userService.findAll();
    }

    @GetMapping("user/{id}")
    public ResponseEntity<?> findByUserId(@PathVariable Long id){

        return  userService.findByUserId(id);
    }
}
