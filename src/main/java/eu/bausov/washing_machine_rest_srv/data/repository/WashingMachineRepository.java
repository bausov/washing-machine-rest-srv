package eu.bausov.washing_machine_rest_srv.data.repository;

import eu.bausov.washing_machine_rest_srv.domain.WashingMachine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by GreenNun on 25/02/2018.
 */
public interface WashingMachineRepository extends CrudRepository<WashingMachine, Long> {
    List<WashingMachine> findAll();
    WashingMachine save(WashingMachine appliance);
}
