package SeleniumProject2;
import  java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
public class ThreadException {




    public void exception() throws InterruptedException{
            final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

            final ScheduledFuture<?> beepHandler =
                    scheduler.scheduleAtFixedRate(new BeepTask(), 2, 2, TimeUnit.SECONDS);

            scheduler.schedule(new Runnable() {

                @Override
                public void run() {
                    beepHandler.cancel(true);
                    scheduler.shutdown();
                }
            }, 27, TimeUnit.SECONDS);
        }

        static class BeepTask implements Runnable {

            public void run() {
                System.out.println("beep");
            }
        }
    }



