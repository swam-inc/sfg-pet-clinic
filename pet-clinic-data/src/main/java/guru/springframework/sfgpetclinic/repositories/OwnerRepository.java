package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.CrudService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.IDN;

@Component
public interface OwnerRepository extends CrudService<Owner, Long> {
    Owner findByLastname(String lastName);
}
