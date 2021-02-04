package alfasense.dto;

import alfasense.models.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    String id;
    String petId;
    Integer quantity;
    Date shipDate;
    OrderStatus status;
    boolean complete;
}

