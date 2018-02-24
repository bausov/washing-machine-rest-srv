package eu.bausov.washing_machine_rest_srv.domain;

import eu.bausov.washing_machine_rest_srv.domain.program.Program;

import java.util.List;

/**
 * Created by GreenNun on 24/02/2018.
 */
public interface Programmable {
    List<Program> getPrograms();
}
