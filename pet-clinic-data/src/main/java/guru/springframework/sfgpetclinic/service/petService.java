package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface petService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
