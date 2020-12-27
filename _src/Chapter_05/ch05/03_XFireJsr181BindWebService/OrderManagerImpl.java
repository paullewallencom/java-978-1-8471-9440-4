
import javax.jws.WebService;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.GregorianCalendar;


@WebService(
        serviceName = "OrderService",
        endpointInterface = "IOrder"
)
public class OrderManagerImpl implements IOrder{

	public OrderManagerImpl(){
		log("OrderManagerImpl.OrderManagerImpl()...");
	}

    public PurchaseOrderType getPurchaseOrderType(String orderId){

            log("OrderManagerImpl.getPurchaseOrderType()...");
            // create an empty PurchaseOrder
            PurchaseOrderType po = new PurchaseOrderType();

            // set the required orderDate attribute
            po.setOrderDate( getDate() );

            // create shipTo USAddress object
            USAddress shipTo = createUSAddress( "Binil Das",
                                                "23 Hidden Range",
                                                "Dallas",
                                                "TX",
                                                "17601" );

            // create billTo USAddress object
            USAddress billTo = createUSAddress( "Binil Das",
                                                "29K Colonial Creast Drive",
                                                "Mountville",
                                                "PA",
                                                "17601" );

            po.setShipTo(shipTo);
            po.setBillTo(billTo);

            return po;
    }

    private static USAddress createUSAddress(  String name, String street,
                                              String city, String state,
                                              String zip ) {

        // create an empty USAddress objects
        USAddress address = new USAddress();

        // set properties on it
        address.setName( name );
        address.setStreet( street );
        address.setCity( city );
        address.setState( state );
        address.setZip( new BigDecimal( zip ) );

        // return it
        return address;
    }

    private static XMLGregorianCalendar getDate() {
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
		}
		catch (DatatypeConfigurationException e) {
			throw new Error(e);
		}
    }

    public static void log(Object msg){
       System.out.println(msg.toString());
    }

}