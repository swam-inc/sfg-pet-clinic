package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.SpecialtyService;
import guru.springframework.sfgpetclinic.service.vetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements vetService {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet save(Vet object) {
        if (object != null ){
            if (object.getSpecialitySet() != null ){
                object.getSpecialitySet().forEach(speciality -> {
                    if ( speciality.getId() == null ){
                        speciality.setId( specialtyService.save(speciality).getId() );
                    }
                });
            } else {
                throw new RuntimeException("Vet needs to have speciality");
            }
            return super.save(object);
        } else {
            return null;
        }

    }

    @Override
    public void delete(Vet object) {
          super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
          super.deleteById(id);
    }
}
