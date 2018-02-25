package eu.bausov.washing_machine_rest_srv.data.service;

import eu.bausov.washing_machine_rest_srv.domain.WashingMachine;

/**
 * Created by GreenNun on 25/02/2018.
 */
public interface WashingMachineService {
    WashingMachine getFirst();
    WashingMachine save(WashingMachine washingMachine);
}
