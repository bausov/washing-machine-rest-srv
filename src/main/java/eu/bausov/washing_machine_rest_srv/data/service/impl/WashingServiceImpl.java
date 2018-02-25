package eu.bausov.washing_machine_rest_srv.data.service.impl;

import eu.bausov.washing_machine_rest_srv.data.repository.WashingRepository;
import eu.bausov.washing_machine_rest_srv.data.service.WashingService;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Washing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GreenNun on 25/02/2018.
 */
@Service
public class WashingServiceImpl implements WashingService {
    private final WashingRepository washingRepository;

    @Autowired
    public WashingServiceImpl(WashingRepository washingRepository) {
        this.washingRepository = washingRepository;
    }

    @Override
    public Washing save(Washing washing) {
        return washingRepository.save(washing);
    }
}
