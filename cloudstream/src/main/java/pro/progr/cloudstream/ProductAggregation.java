package pro.progr.cloudstream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAggregation {
    private String productId;
    private int totalQuantity;
    private double totalRevenue;
}
