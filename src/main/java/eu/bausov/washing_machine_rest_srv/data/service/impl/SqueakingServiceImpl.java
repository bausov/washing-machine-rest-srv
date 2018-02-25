package eu.bausov.washing_machine_rest_srv.data.service.impl;

import eu.bausov.washing_machine_rest_srv.data.repository.SqueakingRepository;
import eu.bausov.washing_machine_rest_srv.data.service.SqueakingService;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Squeaking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GreenNun on 25/02/2018.
 */
@Service
public class SqueakingServiceImpl implements SqueakingService {
    private final SqueakingRepository squeakingRepository;

    @Autowired
    public SqueakingServiceImpl(SqueakingRepository squeakingRepository) {
        this.squeakingRepository = squeakingRepository;
    }

    @Override
    public Squeaking save(Squeaking squeaking) {
        return squeakingRepository.save(squeaking);
    }
}
