package Engine.Managers;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by Gref on 29.05.2016.
 */
public class AudioManager {

    private HashMap<String, Thread> threads = new HashMap<>();

    private class AudioListener implements LineListener{

        private boolean waiting = true;


        @Override
        public synchronized void update(LineEvent event) {

            LineEvent.Type eventType = event.getType();

            if (eventType == LineEvent.Type.STOP ||
                    eventType == LineEvent.Type.CLOSE) {

                waiting = false; notifyAll();
            }
        }

        public synchronized void waitUntilDone() throws InterruptedException {
            while (waiting) { wait(); }
        }

    }

    public void play (String path){

        Thread thread = new Thread(() -> {

            AudioListener listener = new AudioListener();

            try (InputStream iStream = AudioManager.class.getClassLoader().getResourceAsStream(path);
                 BufferedInputStream bStream = new BufferedInputStream(iStream);
                 AudioInputStream stream = AudioSystem.getAudioInputStream(bStream);
                 Clip clip = AudioSystem.getClip()){

                clip.addLineListener(listener);
                clip.open(stream);
                clip.start();

                listener.waitUntilDone();

            }
            catch (Exception e){
                e.printStackTrace(java.lang.System.out);
            }
        });
        threads.put(path, thread);
        thread.start();
    }

    public void stop(String path){
        if(threads.containsKey(path)){
            threads.get(path).stop();
            threads.remove(path);
        }
    }

}
