package pro.progr.cloudstream;


import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class ProductSalesAggregatorService {

    private final Map<String, ProductAggregation> aggregationMap = new HashMap<>();

    @Bean
    public Function<Message<PurchaseEvent>, Message<ProductAggregation>> processPurchases() {
        return message -> {
            PurchaseEvent purchaseEvent = message.getPayload();

            // Получаем текущее агрегированное значение для продукта
            ProductAggregation currentAggregation = aggregationMap.getOrDefault(
                    purchaseEvent.getProductId(),
                    new ProductAggregation(purchaseEvent.getProductId(), 0, 0.0)
            );

            // Обновляем агрегированные данные
            currentAggregation.setTotalQuantity(
                    currentAggregation.getTotalQuantity() + purchaseEvent.getQuantity()
            );
            currentAggregation.setTotalRevenue(
                    currentAggregation.getTotalRevenue() + (purchaseEvent.getPrice() * purchaseEvent.getQuantity())
            );

            // Сохраняем обновленное агрегированное значение
            aggregationMap.put(purchaseEvent.getProductId(), currentAggregation);

            // Возвращаем результат агрегации
            return MessageBuilder.withPayload(currentAggregation).build();
        };
    }
}
