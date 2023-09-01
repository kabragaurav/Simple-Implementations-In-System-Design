package implementations;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

/**
 * Class to implement simple features of a message broker
 * Features are very simple: pub and sub
 * Uses Thread class
 * 
 * @author gaurav kabra
 * @since Sept 2023
 */
public class Kafka {
    
    // Seperates key from val
    private String seperator;
    private Queue<Message> queue;

    Kafka(String seperator) {
        this();
        this.seperator = seperator;
    }

    Kafka() {
        queue = new ArrayDeque<>();
    }


    public class Producer extends Thread {
        
        private int counter;

        @Override
        public void run() {
            while (true) {
                Message message = new Message("Producer msg: " + counter++);
                queue.offer(message);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    // pass
                }
            }
        }

    }


    public class Consumer extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    // 1 sec delay so sometimes, empty queue message is also printed
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    // pass
                }
                Message message = queue.poll();
                Optional.ofNullable(message)
                    .ifPresentOrElse(msg -> {
                        System.out.println("Read message: " + msg);
                    },
                    () -> System.out.println("Queue is empty..."));
            }
        }
        
    }

    private class Message {
        
        private String key;
        private String val;

        /**
         * User can only provide val
         * Or can provide key and val
         */
        Message(String message) {
            if (!Optional.ofNullable(seperator).isPresent()) {
                this.val = message;
                return;
            }
            String[] seperated = message.split(seperator, 2);
            // even after declaring, user might not provide seperator
            if (seperated.length == 2) {
                key = seperated[0];
                val = seperated[1];
            } else {
                val = seperated[0];
            }

        }

        @Override
        public String toString() {
            return Optional.ofNullable(seperator).isPresent() ? key + seperator + val 
                    : val;
        }
    }
}
