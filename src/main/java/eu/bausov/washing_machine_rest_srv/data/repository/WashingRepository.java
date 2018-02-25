package eu.bausov.washing_machine_rest_srv.data.repository;

import eu.bausov.washing_machine_rest_srv.domain.program.process.Washing;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by GreenNun on 25/02/2018.
 */
public interface WashingRepository extends CrudRepository<Washing, Long> {
    Washing save(Washing washing);
}
