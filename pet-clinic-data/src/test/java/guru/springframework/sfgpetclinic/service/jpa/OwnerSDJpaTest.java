package guru.springframework.sfgpetclinic.service.jpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaTest {
    public static final String LAST_NAME = "lastName";
    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpa  service;

    Owner owner1;
    @BeforeEach
    void setUp() {
        owner1 = Owner.builder().id(1l).lastName(LAST_NAME).build();


    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner1));

        Owner owner = service.findById(1L);

        assertNotNull(owner);

        when(ownerRepository.findById(any())).thenReturn(Optional.empty());

        Owner notExistingOwner = service.findById(1L);
        assertNull(notExistingOwner);

    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSets = new HashSet<>();
        returnOwnerSets.add(Owner.builder().id(1l).build());
        returnOwnerSets.add(Owner.builder().id(2l).build());
        Set<Owner>  testSets = new HashSet<>();
        when(ownerRepository.findAll()).thenReturn(returnOwnerSets);
        //when(ownerRepository.findAll()).thenReturn(testSets);
        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2, service.findAll().size());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner1);
        assertNotNull(service.save(owner1));
    }

    @Test
    void delete() {
        service.delete(owner1);
        verify( ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(any());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastname(any())).thenReturn(owner1);
        Owner smith = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, smith.getLastName());
        verify(ownerRepository).findByLastname(any());
    }
}