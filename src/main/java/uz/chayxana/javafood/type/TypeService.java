package uz.chayxana.javafood.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.delivery.DeliveryRepo;
import uz.chayxana.javafood.dto.DeliveryRequest;
import uz.chayxana.javafood.dto.DeliveryResponse;
import uz.chayxana.javafood.dto.TypeRequest;
import uz.chayxana.javafood.dto.TypeResponse;
import uz.chayxana.javafood.organization.Organization;
import uz.chayxana.javafood.organization.OrganizationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TypeService {

    @Autowired
    TypeRepo typeRepo;
    @Autowired
    OrganizationService organizationService;
}
