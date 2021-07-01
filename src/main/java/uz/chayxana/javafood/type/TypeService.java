package uz.chayxana.javafood.type;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.dto.DeliveryRequest;
import uz.chayxana.javafood.dto.DeliveryResponse;
import uz.chayxana.javafood.dto.TypeRequest;
import uz.chayxana.javafood.dto.TypeResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TypeService {

    private final TypeRepo typeRepo;

    public TypeService(
            TypeRepo typeRepo
    ) {
        this.typeRepo = typeRepo;
    }

    public ResponseEntity<?> findAll() {
        List<?> types = typeRepo.findAllByTrashIsFalse()
                .stream().map(TypeResponse::entityToResponse).collect(Collectors.toList());
        if (types.isEmpty())
            return new ResponseEntity(types, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(types, HttpStatus.OK);
    }

    public Optional<Type> findById(Long id) {
        return typeRepo.findById(id);
    }


    public ResponseEntity<?> add(TypeRequest req) {
        try {

            return new ResponseEntity(
                    TypeResponse.entityToResponse(typeRepo.save(Type.reqToEntity(req)))
                    , HttpStatus.OK);

        } catch (DataIntegrityViolationException divEx) {
            System.out.println(divEx.getMessage());
            return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<?> edit(Long id, TypeRequest req) {
        Optional<Type> typeOptional = findById(id);
        if (typeOptional.isPresent()) {
            try {
                return new ResponseEntity(
                        TypeResponse.entityToResponse(typeRepo.save(Type.reqToEntity(typeOptional.get(), req)))
                        , HttpStatus.OK);
            } catch (DataIntegrityViolationException divEx) {
                System.out.println(divEx.getMessage());
                return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> delete(Long id) {
        Optional<Type> typeOptional = findById(id);
        if (typeOptional.isPresent()) {

            Type type = typeOptional.get();
            type.setTrash(true);
            typeRepo.save(type);
            return new ResponseEntity("SUCCESS", HttpStatus.OK);

        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND);
        }

    }
}
