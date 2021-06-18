package uz.chayxana.javafood.additionalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdditionalService {
    @Autowired
    AdditionalRepo additionalRepo;

    public List<?> findAll() {
        return additionalRepo.findAll();
    }

    public Additional getOne(Long id) {
        Optional<Additional> additionalOptional = additionalRepo.findById(id);
        if (additionalOptional.isPresent())
            return additionalOptional.get();
        else return new Additional();
    }

    public String add(Additional additional) {
        additionalRepo.save(additional);
        return "success";
    }

    public String delete(Long id) {
        additionalRepo.deleteById(id);
        return "success";
    }
}
