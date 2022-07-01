package shopping.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shopping.order.proto.Item;
import shopping.order.proto.OrderRequest;
import shopping.order.proto.OrderResponse;
import shopping.order.proto.ShoppingOrderService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public final class ShoppingOrderServiceImpl implements ShoppingOrderService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public CompletionStage<OrderResponse> order(OrderRequest in) {
        int total = in.getItemsList().stream().mapToInt(Item::getQuantity).sum();
        logger.info("Order {} items from cart {}.", total, in.getCartId());
        OrderResponse response = OrderResponse.newBuilder().setOk(true).build();
        return CompletableFuture.completedFuture(response);
    }
}
