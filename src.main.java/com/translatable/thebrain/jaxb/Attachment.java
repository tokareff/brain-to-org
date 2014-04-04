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
    "attachmentEntries",
    "objectID",
    "name",
    "attachmentType",
    "location",
    "dataLength",
    "format",
    "creationDateTime",
    "modificationDateTime",
    "deletedDateTime"
})
@XmlRootElement(name = "Attachment")
public class Attachment {

    @XmlElement(required = true)
    protected String guid;
    @XmlElement(name = "AttachmentEntries")
    protected AttachmentEntries attachmentEntries;
    @XmlElement(required = true)
    protected String objectID;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String attachmentType;
    @XmlElement(required = true)
    protected String location;
    protected String dataLength;
    protected String format;
    protected String creationDateTime;
    protected String modificationDateTime;
    protected String deletedDateTime;

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
     * Gets the value of the attachmentEntries property.
     * 
     * @return
     *     possible object is
     *     {@link AttachmentEntries }
     *     
     */
    public AttachmentEntries getAttachmentEntries() {
        return attachmentEntries;
    }

    /**
     * Sets the value of the attachmentEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentEntries }
     *     
     */
    public void setAttachmentEntries(AttachmentEntries value) {
        this.attachmentEntries = value;
    }

    /**
     * Gets the value of the objectID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectID() {
        return objectID;
    }

    /**
     * Sets the value of the objectID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectID(String value) {
        this.objectID = value;
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
     * Gets the value of the attachmentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentType() {
        return attachmentType;
    }

    /**
     * Sets the value of the attachmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentType(String value) {
        this.attachmentType = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the dataLength property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataLength() {
        return dataLength;
    }

    /**
     * Sets the value of the dataLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataLength(String value) {
        this.dataLength = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
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

}
