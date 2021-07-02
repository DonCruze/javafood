package uz.chayxana.javafood.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.chayxana.javafood.dto.UserResponse;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public ResponseEntity<?> findAll() {
        List<UserResponse> users = userRepo.findAll()
                .stream().map(UserResponse::entityToResponse).collect(Collectors.toList());
        if (users.isEmpty()) {
            return new ResponseEntity<>("Not found users", HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }

    public Optional<User> findById(Long id){

        return userRepo.findById(id);

    }

    public ResponseEntity<?> findByUserId(Long id) {
        Optional<User> user = findById(id);

        if ( user.isPresent()) {
            return new ResponseEntity<>(UserResponse.entityToResponse(user.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not found users", HttpStatus.NOT_FOUND);

        }
    }

}


