package org.delivery.api.domain.userorder.producer;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.rabbitmq.Producer;
import org.delivery.common.message.model.UserOrderMessage;
import org.delivery.db.userorder.UserOrderEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserOrderProducer {

    private final Producer producer;

    private static final String EXCHANGE = "delivery.exchange";
    private static final String ROUTE_KEY = "delivery.key";

    public void sendOrder(UserOrderEntity userOrderEntity){
        sendOrder(userOrderEntity.getId());
    }

    public void sendOrder(Long userOrderId){
        var message = UserOrderMessage.builder()
            .userOrderId(userOrderId)
            .build();

        producer.producer(EXCHANGE, ROUTE_KEY, message);
    }
}
