package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService <T extends BaseEntity, ID extends Long>{
    protected Map<Long, T> map = new HashMap<>();

    T findById( ID id){
        return map.get(id);
    }
    Set<T> findAll(){
        return new HashSet<T>(map.values());
    }
    T save(T object){
        if(object != null) {
            if (object.getId() == null ) {
                object.setId(generateID());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }
    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
    void deleteById(ID id){
        map.remove(id);
    }
    Long generateID(){
        Long id;
        if(map.size() == 0 ){
            id = 1L;
        } else {
            id = Collections.max(map.keySet()) + 1;
        }
        return id;
    }
}
