package uz.chayxana.javafood.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.dto.DeliveryRequest;
import uz.chayxana.javafood.dto.DeliveryResponse;
import uz.chayxana.javafood.dto.MenuRequest;
import uz.chayxana.javafood.dto.MenuResponse;
import uz.chayxana.javafood.organization.Organization;
import uz.chayxana.javafood.organization.OrganizationService;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    MenuRepo menuRepo;
    @Autowired
    OrganizationService organizationService;


}
