//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.19 at 10:38:22 PM EST 
//


package com.translatable.thebrain.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "guid",
    "name",
    "personalBrainVersion",
    "telepathyVersion",
    "fileRoot",
    "generatedDateTime",
    "homeThoughtGuid",
    "brainXmlSettings",
    "modificationDateTime"
})
@XmlRootElement(name = "Source")
public class Source {

    protected String guid;
    protected String name;
    protected String personalBrainVersion;
    protected String telepathyVersion;
    protected String fileRoot;
    protected String generatedDateTime;
    protected String homeThoughtGuid;
    protected String brainXmlSettings;
    protected String modificationDateTime;

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
     * Gets the value of the personalBrainVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalBrainVersion() {
        return personalBrainVersion;
    }

    /**
     * Sets the value of the personalBrainVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalBrainVersion(String value) {
        this.personalBrainVersion = value;
    }

    /**
     * Gets the value of the telepathyVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelepathyVersion() {
        return telepathyVersion;
    }

    /**
     * Sets the value of the telepathyVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelepathyVersion(String value) {
        this.telepathyVersion = value;
    }

    /**
     * Gets the value of the fileRoot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileRoot() {
        return fileRoot;
    }

    /**
     * Sets the value of the fileRoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileRoot(String value) {
        this.fileRoot = value;
    }

    /**
     * Gets the value of the generatedDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneratedDateTime() {
        return generatedDateTime;
    }

    /**
     * Sets the value of the generatedDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneratedDateTime(String value) {
        this.generatedDateTime = value;
    }

    /**
     * Gets the value of the homeThoughtGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeThoughtGuid() {
        return homeThoughtGuid;
    }

    /**
     * Sets the value of the homeThoughtGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeThoughtGuid(String value) {
        this.homeThoughtGuid = value;
    }

    /**
     * Gets the value of the brainXmlSettings property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrainXmlSettings() {
        return brainXmlSettings;
    }

    /**
     * Sets the value of the brainXmlSettings property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrainXmlSettings(String value) {
        this.brainXmlSettings = value;
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

}
