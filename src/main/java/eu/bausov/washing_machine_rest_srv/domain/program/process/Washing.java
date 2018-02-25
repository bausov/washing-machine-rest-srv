package eu.bausov.washing_machine_rest_srv.domain.program.process;

/**
 * Created by GreenNun on 24/02/2018.
 */
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
