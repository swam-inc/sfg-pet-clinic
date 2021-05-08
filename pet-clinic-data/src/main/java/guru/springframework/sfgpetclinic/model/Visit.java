package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="visits")
public class Visit extends  BaseEntity{
    @Column(name="local_date")
    private LocalDate lastVisitDate;
    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;
    @Column(name="description")
    private String description;

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
