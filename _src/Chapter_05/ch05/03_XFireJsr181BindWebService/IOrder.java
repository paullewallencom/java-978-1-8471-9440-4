
import javax.jws.WebService;
import javax.jws.WebResult;

@WebService
public interface IOrder {

    @WebResult(name="PurchaseOrderType")
    public PurchaseOrderType getPurchaseOrderType(String orderId);
}