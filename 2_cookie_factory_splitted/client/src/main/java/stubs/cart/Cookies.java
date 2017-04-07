
package stubs.cart;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cookies.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="cookies"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CHOCOLALALA"/&gt;
 *     &lt;enumeration value="DARK_TEMPTATION"/&gt;
 *     &lt;enumeration value="SOO_CHOCOLATE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "cookies")
@XmlEnum
public enum Cookies {

    CHOCOLALALA,
    DARK_TEMPTATION,
    SOO_CHOCOLATE;

    public String value() {
        return name();
    }

    public static Cookies fromValue(String v) {
        return valueOf(v);
    }

}
