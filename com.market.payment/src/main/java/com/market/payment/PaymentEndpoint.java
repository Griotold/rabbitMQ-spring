package com.market.payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * XxxEndpoint 라는 의미 : 사용자에게 입력을 받지않는 객체
 *                        해당 객체는 컨슈머로, 메시지 큐로부터 데이터를 가져오고 있다.
 * */
@Slf4j
@Component
public class PaymentEndpoint {

    @Value("${spring.application.name}")
    private String appName;

    @RabbitListener(queues = "${message.queue.payment}")
    public void receiveMessage(String orderId) {
        log.info("receive orderId:{}, appName : {}", orderId, appName);
    }
}
