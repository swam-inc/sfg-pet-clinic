package guru.springframework.sfgpetclinic.model;

import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Person.class)
public class PersonTest {

    @Before("")
    public void setUp() throws Exception {
    }

    @Test
    public void getFirstName() {
        Person person = new Person();
        person.setFirstName("steven");
        assertEquals(person.getFirstName(), "steven");
    }
}