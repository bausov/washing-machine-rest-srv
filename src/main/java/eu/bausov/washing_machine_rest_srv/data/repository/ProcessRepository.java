package eu.bausov.washing_machine_rest_srv.data.repository;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by GreenNun on 25/02/2018.
 */
public interface ProcessRepository extends CrudRepository<Process, Long> {
    Process save(Process process);
}
