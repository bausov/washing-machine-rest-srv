package eu.bausov.washing_machine_rest_srv.domain.program.process;

/**
 * Created by GreenNun on 24/02/2018.
 */
abstract class Process {
    private Long duration;
    private Byte temperature;
    private Short rotationSpeed;

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Byte getTemperature() {
        return temperature;
    }

    public void setTemperature(Byte temperature) {
        this.temperature = temperature;
    }

    public Short getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(Short rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }
}
