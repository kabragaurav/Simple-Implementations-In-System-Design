package implementations;

/**
 * Simple test for Kefka.java class
 * 
 * @author gaurav kabra
 * @since Sept 2023
 */
public class KafkaTest {

    public static void main(String[] args) {
        // Kafka kafka = new Kafka();
        // Kafka.Producer producer = kafka.new Producer();
        // Kafka.Consumer consumer = kafka.new Consumer();

        // producer.start();
        // consumer.start();

        /*
         * OUTPUT:
         * 
            Read message: Producer msg: 0
            Read message: Producer msg: 1
            Read message: Producer msg: 2
            Read message: Producer msg: 3
            Read message: Producer msg: 4
            Read message: Producer msg: 5
            Read message: Producer msg: 6
            Read message: Producer msg: 7
            Read message: Producer msg: 8
            Read message: Producer msg: 9
            Read message: Producer msg: 10
         */

        Kafka kafka = new Kafka(":");
        Kafka.Producer producer = kafka.new Producer();
        Kafka.Consumer consumer = kafka.new Consumer();

        producer.start();
        consumer.start();
    }
    
}
