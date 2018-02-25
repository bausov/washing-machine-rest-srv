package eu.bausov.washing_machine_rest_srv.data.service;

import eu.bausov.washing_machine_rest_srv.domain.program.Program;

/**
 * Created by GreenNun on 25/02/2018.
 */
public interface ProgramService {
    Program save(Program program);
}
