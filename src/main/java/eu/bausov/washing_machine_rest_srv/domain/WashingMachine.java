package eu.bausov.washing_machine_rest_srv.domain;

import eu.bausov.washing_machine_rest_srv.domain.program.Program;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by GreenNun on 24/02/2018.
 */
public class WashingMachine implements Appliance, Programmable  {
    private String model;
    private String serial;
    private List<Program> programs;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }
}
