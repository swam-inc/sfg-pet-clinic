package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.CrudService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.IDN;

@Service
public interface     OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastname(String lastName);

}
