package eu.bausov.washing_machine_rest_srv.data.service.impl;

import eu.bausov.washing_machine_rest_srv.data.repository.ProcessRepository;
import eu.bausov.washing_machine_rest_srv.data.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GreenNun on 25/02/2018.
 */
@Service
public class ProcessServiceImpl implements ProcessService {
    private final ProcessRepository processRepository;

    @Autowired
    public ProcessServiceImpl(ProcessRepository processRepository) {
        this.processRepository = processRepository;
    }

    @Override
    public Process save(Process process) {
        return processRepository.save(process);
    }
}
