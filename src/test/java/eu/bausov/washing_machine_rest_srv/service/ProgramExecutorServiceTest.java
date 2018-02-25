package eu.bausov.washing_machine_rest_srv.service;

import eu.bausov.washing_machine_rest_srv.domain.program.Program;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Drying;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Squeaking;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Washing;
import eu.bausov.washing_machine_rest_srv.util.States;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by GreenNun on 24/02/2018.
 */
public class ProgramExecutorServiceTest {
    private ProgramExecutorService programExecutorService = new ProgramExecutorService();

    @Before
    public void setUp() throws Exception {
        Washing washing = new Washing(100L, 90, 30);
        Squeaking squeaking = new Squeaking(100L, -1, 1000);
        Drying drying = new Drying(100L, 40, 15);
        Program program = new Program(washing, squeaking, drying);

        programExecutorService.setProgram(program);
    }

    @Test
    public void startProgram() throws Exception {
        programExecutorService.startProgram();
        String status = programExecutorService.getStatus();
        Assert.assertTrue(status.startsWith(States.RUNNING.toString()));
    }

    @Test
    public void stopProgram() throws Exception {
        programExecutorService.startProgram();
        programExecutorService.stopProgram();
        String status = programExecutorService.getStatus();
        Assert.assertTrue(status.startsWith(States.STOPPED.toString()));
    }

    @Test
    public void getStatus() throws InterruptedException {
        String status = programExecutorService.getStatus();
        Assert.assertTrue(status.startsWith(States.WAITING.toString()));
        programExecutorService.startProgram();
        status = programExecutorService.getStatus();
        Assert.assertTrue(status.startsWith(States.RUNNING.toString()));
        programExecutorService.stopProgram();
        status = programExecutorService.getStatus();
        Assert.assertTrue(status.startsWith(States.STOPPED.toString()));
        programExecutorService.startProgram();
        status = programExecutorService.getStatus();
        Assert.assertTrue(status.startsWith(States.RUNNING.toString()));

        TimeUnit.MILLISECONDS.sleep(1000);

        status = programExecutorService.getStatus();
        Assert.assertTrue(status.startsWith(States.FINISHED.toString()));
    }

    @Test
    public void getStatus_waiting() {
        String status = programExecutorService.getStatus();
        Assert.assertTrue(status.startsWith(States.WAITING.toString()));
    }

    @Test
    public void getStatus_running() throws InterruptedException {
        programExecutorService.startProgram();
        String status = programExecutorService.getStatus();
        Assert.assertTrue(status.startsWith(States.RUNNING.toString()));
    }

    @Test
    public void getStatus_stopped() throws InterruptedException {
        programExecutorService.startProgram();
        programExecutorService.stopProgram();
        String status = programExecutorService.getStatus();
        Assert.assertTrue(status.startsWith(States.STOPPED.toString()));
    }

    @Test
    public void getStatus_finished() throws InterruptedException {
        programExecutorService.startProgram();

        TimeUnit.MILLISECONDS.sleep(1000);

        String status = programExecutorService.getStatus();
        Assert.assertTrue(status.startsWith(States.FINISHED.toString()));
    }
}