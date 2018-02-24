package eu.bausov.washing_machine_rest_srv.domain.program;

import eu.bausov.washing_machine_rest_srv.domain.program.process.Drying;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Squeaking;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Washing;

/**
 * Created by GreenNun on 24/02/2018.
 */
public class Program {
    private Washing washing;
    private Squeaking squeaking;
    private Drying drying;

    public Washing getWashing() {
        return washing;
    }

    public void setWashing(Washing washing) {
        this.washing = washing;
    }

    public Squeaking getSqueaking() {
        return squeaking;
    }

    public void setSqueaking(Squeaking squeaking) {
        this.squeaking = squeaking;
    }

    public Drying getDrying() {
        return drying;
    }

    public void setDrying(Drying drying) {
        this.drying = drying;
    }
}
