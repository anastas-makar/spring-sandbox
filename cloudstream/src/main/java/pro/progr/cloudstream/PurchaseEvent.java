package pro.progr.cloudstream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseEvent {
    private String productId;
    private int quantity;
    private double price;
}
