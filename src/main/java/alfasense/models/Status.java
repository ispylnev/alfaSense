package alfasense.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Status {

    AVAILABLE("available"),

    PENDING("pending"),

    SOLD("sold");

    String status;
}

