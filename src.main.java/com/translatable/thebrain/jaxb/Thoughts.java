//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.19 at 10:38:22 PM EST 
//


package com.translatable.thebrain.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "thought"
})
@XmlRootElement(name = "Thoughts")
public class Thoughts {

    @XmlElement(name = "Thought", required = true)
    protected List<Thought> thought;

    /**
     * Gets the value of the thought property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thought property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThought().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Thought }
     * 
     * 
     */
    public List<Thought> getThought() {
        if (thought == null) {
            thought = new ArrayList<Thought>();
        }
        return this.thought;
    }

}
