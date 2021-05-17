package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    private final OwnerServiceMap ownerServiceMap = new OwnerServiceMap();
    private Long id = 1L;
    @BeforeEach
    void setUp() {
        Owner owner = Owner.builder().id(1l).lastName("lastName").build();
        ownerServiceMap.save(owner);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById() {
        Owner owner2 = ownerServiceMap.findById(id);
        assertNotNull(owner2);
    }

    @Test
    void findAll() {
        Owner owner3 = Owner.builder().id(2l).lastName("LastName").build();

        ownerServiceMap.save(owner3);
        assertEquals(2, ownerServiceMap.findAll().size());
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(id));
        assertNull(ownerServiceMap.findById(id));
    }

    @Test
    void deleteById() {
        Owner owner4 = Owner.builder().id(3l).lastName("lastName").build();

        ownerServiceMap.save(owner4);
        assertNotNull(ownerServiceMap.findById(id));
        ownerServiceMap.deleteById(id);
        assertNull(ownerServiceMap.findById(id));
    }

    @Test
    void findByLastName() {
        String lastName = "abc";
        assertNull(ownerServiceMap.findByLastName(lastName));
        Owner owner5 = Owner.builder().id(4l).lastName("lastName").build();

        ownerServiceMap.save(owner5);
        assertNotNull(ownerServiceMap.findByLastName("lastName"));
    }
}