package eu.bausov.washing_machine_rest_srv.data.service.impl;

import eu.bausov.washing_machine_rest_srv.data.repository.WashingMachineRepository;
import eu.bausov.washing_machine_rest_srv.data.service.WashingMachineService;
import eu.bausov.washing_machine_rest_srv.domain.WashingMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GreenNun on 25/02/2018.
 */
@Service
public class WashingMachineServiceImpl implements WashingMachineService {
    private final WashingMachineRepository washingMachineRepository;

    @Autowired
    public WashingMachineServiceImpl(WashingMachineRepository washingMachineRepository) {
        this.washingMachineRepository = washingMachineRepository;
    }

    @Override
    public WashingMachine getFirst() {
        List<WashingMachine> all = washingMachineRepository.findAll();
        return all.size() == 0 ? null : all.get(0);
    }

    @Override
    public WashingMachine save(WashingMachine washingMachine) {
        return washingMachineRepository.save(washingMachine);
    }
}
