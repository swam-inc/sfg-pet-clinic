package guru.springframework.sfgpetclinic.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class PersonTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getFirstName() {
        Person person = new Person();
        person.setFirstName("steven");
        assertEquals(person.getFirstName(), "steven");
    }
}