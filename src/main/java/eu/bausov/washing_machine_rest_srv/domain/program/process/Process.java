package eu.bausov.washing_machine_rest_srv.domain.program.process;

/**
 * Created by GreenNun on 24/02/2018.
 */
public abstract class Process {
    private Long duration;
    private Integer temperature;
    private Integer rotationSpeed;

    public Process() {
    }

    public Process(Long duration, Integer temperature, Integer rotationSpeed) {
        this.duration = duration;
        this.temperature = temperature;
        this.rotationSpeed = rotationSpeed;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(Integer rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    @Override
    public String toString() {
        return "{" +
                "duration=" + duration +
                ", temperature=" + temperature +
                ", rotationSpeed=" + rotationSpeed +
                '}';
    }
}
