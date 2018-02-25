package eu.bausov.washing_machine_rest_srv.data.service.impl;

import eu.bausov.washing_machine_rest_srv.data.repository.DryingRepository;
import eu.bausov.washing_machine_rest_srv.data.service.DryingService;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Drying;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GreenNun on 25/02/2018.
 */
@Service
public class DryingServiceImpl implements DryingService {
    private final DryingRepository dryingRepository;

    @Autowired
    public DryingServiceImpl(DryingRepository dryingRepository) {
        this.dryingRepository = dryingRepository;
    }

    @Override
    public Drying save(Drying drying) {
        return dryingRepository.save(drying);
    }
}
