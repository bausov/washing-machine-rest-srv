package eu.bausov.washing_machine_rest_srv.data.service.impl;

import eu.bausov.washing_machine_rest_srv.data.repository.ProgramRepository;
import eu.bausov.washing_machine_rest_srv.data.service.ProgramService;
import eu.bausov.washing_machine_rest_srv.domain.program.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GreenNun on 25/02/2018.
 */
@Service
public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepository programRepository;

    @Autowired
    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public Program save(Program program) {
        return programRepository.save(program);
    }
}
