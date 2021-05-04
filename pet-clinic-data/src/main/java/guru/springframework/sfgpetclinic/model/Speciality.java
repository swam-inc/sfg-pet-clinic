package guru.springframework.sfgpetclinic.model;

public class Speciality extends  BaseEntity{
    private String specialityName;

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }
}
