package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findById( Long id){
        return super.findById(id);
    }
    @Override
    public Set<Owner> findAll(){
        return super.findAll();
    }
    @Override
    public Owner save(Owner object){
        if(object != null ){
            if (object.getPets() != null ){
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null ){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(pet.getPetType());
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null ){
                        PetServiceMap petServiceMap = new PetServiceMap();
                        Pet savedPet = petServiceMap.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save( object);
        }else{
            return null;
        }


    }
    @Override
    public void delete(Owner object) {
        super.delete(object);
    }
    @Override
    public void deleteById(Long id){
        super.deleteById(id);
    }
    public Owner findByLastName(String lastName){
        for ( Long id : map.keySet()){
            if (map.get(id).getLastName().equals(lastName)){ return map.get(id); }
        }
        return  null;
    }
}
