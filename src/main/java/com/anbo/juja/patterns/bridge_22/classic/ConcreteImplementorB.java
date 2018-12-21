package com.anbo.juja.patterns.bridge_22.classic;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by oleksandr.baglai on 25.02.2016.
 */
public class ConcreteImplementorB extends Implementor {

    private final SpeechUtils speechUtils;
    private ExecutorService executorService;
    private Queue<Character> chars = new ConcurrentLinkedDeque<>();
    private Future<Void> future;

    public ConcreteImplementorB(SpeechUtils speechUtils) {
        try {
            this.speechUtils = speechUtils;
            speechUtils.init("kevin16");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        executorService = Executors.newSingleThreadExecutor();
    }

    private void startSpeech() {
        future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                while (!chars.isEmpty()) {
                    Character ch = chars.poll();

                    speechUtils.doSpeak(String.valueOf(ch));
                }

                try {
                    speechUtils.terminate();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                executorService.shutdown();

                return null;
            }
        });
    }

    @Override
    public void operationImpl(char data) {
        chars.add(data);
        if (future == null) {
            startSpeech();
        }
    }
    
}
