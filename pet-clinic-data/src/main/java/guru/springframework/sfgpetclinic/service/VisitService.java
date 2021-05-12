package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitService extends CrudService<Visit, Long> {
}
