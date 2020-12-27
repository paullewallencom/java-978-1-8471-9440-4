//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b26-ea3
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2006.05.26 at 05:26:04 PM IST
//


//package primer.po;

//import javax.xml.bind.annotation.AccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlAttribute;
//import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
//import primer.po.Items;
//import primer.po.PurchaseOrderType;
//import primer.po.USAddress;


/**
 * <p>Java class for PurchaseOrderType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PurchaseOrderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="shipTo" type="{}USAddress"/>
 *         &lt;element name="billTo" type="{}USAddress"/>
 *         &lt;element ref="{}comment" minOccurs="0"/>
 *         &lt;element name="items" type="{}Items"/>
 *       &lt;/sequence>
 *       &lt;attribute name="orderDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
//@XmlAccessorType(AccessType.FIELD)
/*@XmlType(name = "PurchaseOrderType", propOrder = {
    "shipTo",
    "billTo",
    "comment",
    "items"
})*/
public class PurchaseOrderType {

	public PurchaseOrderType(){}

    protected USAddress shipTo;
    protected USAddress billTo;
    protected String comment;
    //protected Items items;
    //@XmlAttribute
    protected XMLGregorianCalendar orderDate;

    /**
     * Gets the value of the shipTo property.
     *
     * @return
     *     possible object is
     *     {@link USAddress }
     *
     */
    public USAddress getShipTo() {
        return shipTo;
    }

    /**
     * Sets the value of the shipTo property.
     *
     * @param value
     *     allowed object is
     *     {@link USAddress }
     *
     */
    public void setShipTo(USAddress value) {
        this.shipTo = value;
    }

    /**
     * Gets the value of the billTo property.
     *
     * @return
     *     possible object is
     *     {@link USAddress }
     *
     */
    public USAddress getBillTo() {
        return billTo;
    }

    /**
     * Sets the value of the billTo property.
     *
     * @param value
     *     allowed object is
     *     {@link USAddress }
     *
     */
    public void setBillTo(USAddress value) {
        this.billTo = value;
    }

    /**
     * Gets the value of the comment property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the items property.
     *
     * @return
     *     possible object is
     *     {@link Items }
     *
     */
/*
    public Items getItems() {
        return items;
    }
*/
    /**
     * Sets the value of the items property.
     *
     * @param value
     *     allowed object is
     *     {@link Items }
     *
     */
/*
    public void setItems(Items value) {
        this.items = value;
    }
*/
    /**
     * Gets the value of the orderDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the value of the orderDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setOrderDate(XMLGregorianCalendar value) {
        this.orderDate = value;
    }

}
