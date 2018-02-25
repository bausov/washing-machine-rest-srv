package eu.bausov.washing_machine_rest_srv.service;

import eu.bausov.washing_machine_rest_srv.data.service.*;
import eu.bausov.washing_machine_rest_srv.domain.WashingMachine;
import eu.bausov.washing_machine_rest_srv.domain.program.Program;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Drying;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Squeaking;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Washing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by GreenNun on 24/02/2018.
 */
@Service
public class InitializeService {
    private final Logger LOGGER = LoggerFactory.getLogger(InitializeService.class);

    private final WashingMachineService washingMachineService;
    private final ProgramService programService;
    private final WashingService washingService;
    private final SqueakingService squeakingService;
    private final DryingService dryingService;

    private WashingMachine washingMachine;

    @Autowired
    public InitializeService(WashingMachineService washingMachineService, ProgramService programService, WashingService washingService, SqueakingService squeakingService, DryingService dryingService) {
        this.washingMachineService = washingMachineService;
        this.programService = programService;
        this.washingService = washingService;
        this.squeakingService = squeakingService;
        this.dryingService = dryingService;
    }

    @PostConstruct
    public void init(){
        LOGGER.info("Washing Machine initializing...");

        washingMachine = washingMachineService.getFirst();
        if (washingMachine == null) {
            LOGGER.warn("Washing Machine not found in database. Init new...");

            washingMachine = newInstance();
        }
    }

    public WashingMachine getWashingMachine() {
        return washingMachine;
    }

    private WashingMachine newInstance() {
        WashingMachine wm = new WashingMachine();
        wm.setModel("ABC22133");
        wm.setSerial("SN-1234567890-123");
        wm.setPrograms(Arrays.asList(
                programService.save(cottonProgram()),
                programService.save(colorProgram()),
                programService.save(syntheticProgram())
        ));

        return washingMachineService.save(wm);
    }

    private Program cottonProgram() {
        Program cotton = new Program();
        cotton.setWashing(washingService.save(new Washing(25000L, 95, 30)));
        cotton.setSqueaking(squeakingService.save(new Squeaking(5000L, -1, 1000)));
        cotton.setDrying(dryingService.save(new Drying(10000L, 40, 10)));

        return cotton;
    }

    private Program colorProgram() {
        Program color = new Program();
        color.setWashing(washingService.save(new Washing(20000L, 40, 30)));
        color.setSqueaking(squeakingService.save(new Squeaking(5000L, -1, 800)));
        color.setDrying(dryingService.save(new Drying(10000L, 40, 10)));

        return color;
    }

    private Program syntheticProgram() {
        Program synthetic = new Program();
        synthetic.setWashing(washingService.save(new Washing(20000L, 60, 30)));
        synthetic.setSqueaking(squeakingService.save(new Squeaking(4000L, -1, 1000)));
        synthetic.setDrying(dryingService.save(new Drying(8000L, 40, 10)));

        return synthetic;
    }
}
