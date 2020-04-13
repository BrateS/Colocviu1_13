package ro.pub.cs.systems.eim.lab03.colocviu1_13;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class Colocviu1_13Service extends Service {

    public Colocviu1_13Service() {
    }

    private int startMode;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent,
                              int flags,
                              int startId) {

        String text = intent.getStringExtra("text");
        ProcessingThread processingThread = new ProcessingThread(this, text);
        processingThread.start();
        return START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public static class ProcessingThread extends Thread {

        private final Context context;
        private String text;

        ProcessingThread(Context context, String text) {
            this.text = text;
            this.context = context;
        }

        @Override
        public void run() {
            sendMessage();
        }


        private void sendMessage() {
            Intent intent = new Intent();
            intent.setAction("action");
            intent.putExtra("text", text);
            context.sendBroadcast(intent);
        }

    }
}
