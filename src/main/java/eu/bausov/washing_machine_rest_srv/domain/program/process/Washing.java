package eu.bausov.washing_machine_rest_srv.domain.program.process;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by GreenNun on 24/02/2018.
 */
@Entity
@DiscriminatorValue("washing")
public class Washing extends Process {
    public Washing() {
    }

    public Washing(Long duration, Integer temperature, Integer rotationSpeed) {
        super(duration, temperature, rotationSpeed);
    }

    @Override
    public String toString() {
        return "Washing " + super.toString();
    }
}
