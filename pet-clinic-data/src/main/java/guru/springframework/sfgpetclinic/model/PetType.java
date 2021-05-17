package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;

/**
 * Created by jt on 7/13/18.
 */
@Entity
    //@MappedSuperclass
@Table(name="pettype")
public class PetType extends BaseEntity {


    @Column(name="name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
