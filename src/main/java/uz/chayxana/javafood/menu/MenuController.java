package uz.chayxana.javafood.menu;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.chayxana.javafood.dto.ContactRequest;
import uz.chayxana.javafood.dto.MenuRequest;


@RestController
@RequestMapping("api/v1")
public class MenuController {

    @Autowired
    MenuService menuService;


    @GetMapping("menu")
    public ResponseEntity<?> findAll() {
        return menuService.findAll();
    }

    @GetMapping("organization/{org_id}/menu")
    public ResponseEntity<?> organizationMenues(@PathVariable Long org_id) {
        return menuService.organizationMenues(org_id);
    }

    @PostMapping("organization/{org_id}/menu")
    public ResponseEntity<?> add(
            @PathVariable(name = "org_id") Long orgId,
            @RequestBody MenuRequest req
    ) {
        return menuService.add(orgId, req);
    }

    @DeleteMapping("menu/{menu_id}")
    public ResponseEntity<?> delete(
            @PathVariable(name = "menu_id") Long menuId
    ) {
        return menuService.delete(menuId);
    }

    @PutMapping("organization/{org_id}/menu/{menu_id}")
    public ResponseEntity<?> edit(
            @PathVariable(name = "org_id") Long orgId,
            @RequestBody MenuRequest req,
            @PathVariable(name = "menu_id") Long menuId
    ) {
        return menuService.edit(orgId, req, menuId);
    }

}
