package alfasense.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum OrderStatus {

    PLACED("placed"),

    APPROVED("approved"),

    DELIVERED("delivered ");

    String status;
}

