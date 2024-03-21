package com.picshop.order.service;

import com.picshop.order.dto.KafkaDto;
import com.picshop.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private KafkaTemplate<String, KafkaDto> kafkaTemplate;

    @Autowired
    public KafkaService(KafkaTemplate<String, KafkaDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderInfo(KafkaDto kafkaDto) {
        // send(String topic, K key, @Nullable V data)
        // send(String topic, Integer partition, K key, @Nullable V data)
        kafkaTemplate.send("pic-shop-order", kafkaDto)
                .whenComplete((sendResult, throwable)->{
                    if (throwable != null) {
                        System.out.println("Ошибка передачи");
                        throw new RuntimeException(throwable);
                    }
                    // header, payload
                    // sendResult.getRecordMetadata().partition();
                    // sendResult.getRecordMetadata().offset();
                    // sendResult.getRecordMetadata().timestamp();

                    // sendResult.getProducerRecord().value()
                });

    }

}
// @Entity
// class KafkaDto {
//      @Column(name = "number_of_order")
//      @JsonProperty("order_number")
//     private UUID number;
//   UUID order_number
// }