//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.19 at 10:38:22 PM EST 
//


package com.translatable.thebrain.jaxb;

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
    "guid",
    "idA",
    "idB",
    "dir",
    "isBackward",
    "name",
    "labelForward",
    "labelBackward",
    "creationDateTime",
    "modificationDateTime",
    "deletedDateTime",
    "followDateTime",
    "isType",
    "color",
    "thickness",
    "strength",
    "meaning",
    "linkTypeID"
})
@XmlRootElement(name = "Link")
public class Link {

    @XmlElement(required = true)
    protected String guid;
    protected String idA;
    protected String idB;
    @XmlElement(required = true)
    protected String dir;
    protected String isBackward;
    protected String name;
    protected String labelForward;
    protected String labelBackward;
    protected String creationDateTime;
    protected String modificationDateTime;
    protected String deletedDateTime;
    protected String followDateTime;
    protected String isType;
    protected String color;
    protected String thickness;
    protected String strength;
    protected String meaning;
    protected String linkTypeID;

    /**
     * Gets the value of the guid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Sets the value of the guid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuid(String value) {
        this.guid = value;
    }

    /**
     * Gets the value of the idA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdA() {
        return idA;
    }

    /**
     * Sets the value of the idA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdA(String value) {
        this.idA = value;
    }

    /**
     * Gets the value of the idB property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdB() {
        return idB;
    }

    /**
     * Sets the value of the idB property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdB(String value) {
        this.idB = value;
    }

    /**
     * Gets the value of the dir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDir() {
        return dir;
    }

    /**
     * Sets the value of the dir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDir(String value) {
        this.dir = value;
    }

    /**
     * Gets the value of the isBackward property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsBackward() {
        return isBackward;
    }

    /**
     * Sets the value of the isBackward property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsBackward(String value) {
        this.isBackward = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the labelForward property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelForward() {
        return labelForward;
    }

    /**
     * Sets the value of the labelForward property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelForward(String value) {
        this.labelForward = value;
    }

    /**
     * Gets the value of the labelBackward property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelBackward() {
        return labelBackward;
    }

    /**
     * Sets the value of the labelBackward property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelBackward(String value) {
        this.labelBackward = value;
    }

    /**
     * Gets the value of the creationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationDateTime() {
        return creationDateTime;
    }

    /**
     * Sets the value of the creationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDateTime(String value) {
        this.creationDateTime = value;
    }

    /**
     * Gets the value of the modificationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModificationDateTime() {
        return modificationDateTime;
    }

    /**
     * Sets the value of the modificationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModificationDateTime(String value) {
        this.modificationDateTime = value;
    }

    /**
     * Gets the value of the deletedDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeletedDateTime() {
        return deletedDateTime;
    }

    /**
     * Sets the value of the deletedDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeletedDateTime(String value) {
        this.deletedDateTime = value;
    }

    /**
     * Gets the value of the followDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFollowDateTime() {
        return followDateTime;
    }

    /**
     * Sets the value of the followDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFollowDateTime(String value) {
        this.followDateTime = value;
    }

    /**
     * Gets the value of the isType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsType() {
        return isType;
    }

    /**
     * Sets the value of the isType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsType(String value) {
        this.isType = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * Gets the value of the thickness property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThickness() {
        return thickness;
    }

    /**
     * Sets the value of the thickness property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThickness(String value) {
        this.thickness = value;
    }

    /**
     * Gets the value of the strength property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrength() {
        return strength;
    }

    /**
     * Sets the value of the strength property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrength(String value) {
        this.strength = value;
    }

    /**
     * Gets the value of the meaning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeaning() {
        return meaning;
    }

    /**
     * Sets the value of the meaning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeaning(String value) {
        this.meaning = value;
    }

    /**
     * Gets the value of the linkTypeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkTypeID() {
        return linkTypeID;
    }

    /**
     * Sets the value of the linkTypeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkTypeID(String value) {
        this.linkTypeID = value;
    }

}
