package eu.bausov.washing_machine_rest_srv.domain;

import eu.bausov.washing_machine_rest_srv.domain.program.Program;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by GreenNun on 24/02/2018.
 */
@Entity
@Table(name = "TB_APPLIANCES")
public class WashingMachine extends JPA implements Appliance, Programmable  {
    private String model;
    private String serial;
    private List<Program> programs;

    @Override
    @Basic(optional = false)
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    @Basic(optional = false)
    @Column(name = "serial")
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(fetch = FetchType.EAGER)
    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }
}
