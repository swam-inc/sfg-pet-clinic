package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface ownerService {
    Owner findById(Long id);
    Owner findByLastName(String lastName);
    Set<Owner> findAll();
    Owner save(Owner owner);
}
