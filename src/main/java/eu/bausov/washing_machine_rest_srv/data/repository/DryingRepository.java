package eu.bausov.washing_machine_rest_srv.data.repository;

import eu.bausov.washing_machine_rest_srv.domain.program.process.Drying;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by GreenNun on 25/02/2018.
 */
public interface DryingRepository extends CrudRepository<Drying, Long> {
    Drying save(Drying process);
}
