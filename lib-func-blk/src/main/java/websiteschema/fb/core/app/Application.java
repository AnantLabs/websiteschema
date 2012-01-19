/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package websiteschema.fb.core.app;

import java.util.Date;
import org.apache.log4j.Logger;
import websiteschema.conf.Configure;
import websiteschema.fb.core.Event;
import websiteschema.fb.core.FBInfo;
import websiteschema.fb.core.FunctionBlock;
import websiteschema.fb.core.RuntimeContext;

/**
 *
 * @author ray
 */
public class Application implements IApplication {

    Logger l = Logger.getLogger(Application.class);
    RuntimeContext context = new RuntimeContext();
    private boolean running = true;
    private long taskId = 0;
    private AppStatus status = new AppStatus();

    public Application() {
    }

    public Application(long taskId) {
        this.taskId = taskId;
        status.setTaskId(taskId);
    }

    public void stop() {
        running = false;
    }

    public RuntimeContext getContext() {
        return context;
    }

    public void run() {
        try {
            call();
        } catch (Exception ex) {
            l.error("FATAL ERROR: exit.", ex);
            status.setMessage("ERROR: " + ex.getMessage());
            status.setStatus(AppStatus.ERROR);
            //设置应用结束时间
            status.setEndTime(new Date());
        }
    }

    public long getTaskId() {
        return this.taskId;
    }

    public AppStatus getStatus() {
        return this.status;
    }

    public AppStatus call() throws Exception {
        Configure config = context.getConfig();
        String initEvent = config.getProperty("InitEvent");
        FunctionBlock start = context.getStartFB();
        start.triggerEvent(initEvent);

        while (running) {
            try {
                Event evt = context.getEventQueue().poll();
                if (null != evt) {
                    FunctionBlock fb = evt.fb;
                    String ei = evt.ei;
                    if (null == fb && ei.equals(Event.CEASE_COMMAND)) {
                        stop();
                        status.setStatus(AppStatus.END);
                    } else {
                        if (!fb.isWithECC()) {
                            Class clazz = fb.getClass();
                            FBInfo fbInfo = context.getFunctionBlockInfo(clazz);
                            String algorithm = fbInfo.getEIRelatedAlgorithm(ei);
                            fb.execute(algorithm, ei);
                        } else {
                            fb.executeEvent(ei);
                        }
                    }
                } else {
                    l.trace("no more event to handle, waiting...");
                    Thread.sleep(100);
                }
            } catch (Exception ex) {
                running = false;
                l.error("FATAL ERROR: exit.", ex);
                status.setMessage("ERROR: " + ex.getMessage());
                status.setStatus(AppStatus.ERROR);
            }
        }
        //设置应用结束时间
        status.setEndTime(new Date());
        return status;
    }
}