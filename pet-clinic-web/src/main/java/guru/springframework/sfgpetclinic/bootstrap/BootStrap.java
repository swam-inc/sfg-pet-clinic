package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.service.*;
import guru.springframework.sfgpetclinic.service.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.service.map.PetServiceMap;
import guru.springframework.sfgpetclinic.service.map.PetTypeServiceMap;
import guru.springframework.sfgpetclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BootStrap implements CommandLineRunner {
    private         OwnerService ownerService ;
    private VetService vetService ;
    private PetService petService ;
    private PetTypeService petTypeService;
    private  final SpecialtyService specialtyService;
    private final VisitService  visitService;

    public BootStrap(OwnerService ownerService, VetService vetService, PetService petService,
                     PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int  count = new PetTypeServiceMap().findAll().size();
        if (count == 0 ) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        cat.setName("Cat");
        PetType  savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setSpecialityName("Radiology");
        specialtyService.save(radiology);

        Speciality  surgery = new Speciality();
        surgery.setSpecialityName("Surgery");
        specialtyService.save(surgery);

        Speciality  dentistry = new Speciality();
        dentistry.setSpecialityName("Dentistry");
        specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");

        owner2.setTelephone("12312231234");
        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);


        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setLastVisitDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        catVisit.setPet(fionasCat);
        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1= new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
