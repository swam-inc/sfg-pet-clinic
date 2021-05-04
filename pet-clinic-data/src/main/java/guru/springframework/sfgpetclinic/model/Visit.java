package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Visit extends  BaseEntity{
    private LocalDate lastVisitDate;
    private Pet pet;
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
