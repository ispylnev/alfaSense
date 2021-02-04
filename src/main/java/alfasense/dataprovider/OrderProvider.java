package alfasense.dataprovider;

import alfasense.dto.Order;
import alfasense.models.OrderStatus;
import alfasense.utils.RandomUtils;
import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.util.Date;

@UtilityClass
public class OrderProvider {

    public static Order getOrderFilledFields() {
        return Order.builder()
                .id(String.valueOf(RandomUtils.getRandomInt()))
                .petId(String.valueOf(RandomUtils.getRandomInt()))
                .quantity(RandomUtils.getRandomInt())
                .shipDate(Date.from(Instant.now()))
                .status(OrderStatus.PLACED)
                .complete(true)
                .build();
    }
}
