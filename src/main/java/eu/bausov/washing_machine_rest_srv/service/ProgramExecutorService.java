package eu.bausov.washing_machine_rest_srv.service;

import eu.bausov.washing_machine_rest_srv.domain.program.Program;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Drying;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Process;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Squeaking;
import eu.bausov.washing_machine_rest_srv.domain.program.process.Washing;
import eu.bausov.washing_machine_rest_srv.util.States;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by GreenNun on 24/02/2018.
 */
@Service
@Scope("singleton")
public class ProgramExecutorService {
    private final Logger LOGGER = LoggerFactory.getLogger(ProgramExecutorService.class);

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private Program program;
    private String status = States.WAITING.toString();
    private Date operationEnd;
    private Date programEnd;
    private AtomicBoolean isRunning = new AtomicBoolean(false);
    private Future<Boolean> future;
    private ReentrantLock lock = new ReentrantLock();

    public void startProgram() throws InterruptedException {
        lock.lock();

        try {
            if (!isRunning.get()) {
                isRunning.set(true);
                status = States.RUNNING.toString();

                Washing washing = program.getWashing();
                Squeaking squeaking = program.getSqueaking();
                Drying drying = program.getDrying();

                programEnd = new Date(System.currentTimeMillis() +
                        washing.getDuration() +
                        squeaking.getDuration() +
                        drying.getDuration()
                );

                future = executor.submit(createProcessRunner(washing, squeaking, drying), true);
            }
        } finally {
            lock.unlock();
        }
    }

    public void stopProgram() {
        lock.lock();

        try {
            if (isRunning.get()) {
                future.cancel(true);
                isRunning.set(false);
                status = States.STOPPED.toString();
            }
        } finally {
            lock.unlock();
        }
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public String getStatus() {
        lock.lock();

        try {
            if (isRunning.get() && operationEnd != null && programEnd != null) {
                Date now = new Date();
                long opEnd = operationEnd.getTime() - now.getTime();
                long progEnd = programEnd.getTime() - now.getTime();

                return status +
                        ",\n\t\toperation estimation: " + (opEnd > 0 ? opEnd : 0) +
                        ",\n\t\tprogram estimation: " + (progEnd > 0 ? progEnd : 0);
            }

            return status;
        } finally {
            lock.unlock();
        }
    }

    private Runnable createProcessRunner(Washing washing, Squeaking squeaking, Drying drying) {
        return () -> {
            runProcess(washing);
            runProcess(squeaking);
            runProcess(drying);

            isRunning.set(false);
            status = States.FINISHED.toString();
        };
    }

    private void runProcess(Process process) {
        lock.lock();

        try {
            operationEnd = new Date(System.currentTimeMillis() + process.getDuration());

            status = States.RUNNING.toString() + ", " + process.toString();
        } finally {
            lock.unlock();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(process.getDuration()); // emulating real process duration
        } catch (InterruptedException e) {
            LOGGER.error("Error while " + process.getClass().getSimpleName() + " operation.");
        }
    }
}
