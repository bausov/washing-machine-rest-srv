package eu.bausov.washing_machine_rest_srv.data.service;

import eu.bausov.washing_machine_rest_srv.domain.program.process.Washing;

/**
 * Created by GreenNun on 25/02/2018.
 */
public interface WashingService {
    Washing save(Washing washing);
}
