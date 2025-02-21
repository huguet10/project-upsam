//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 10:03:45 PM CET 
//


package com.upsam.hospital.model.jaxb;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}trial"/>
 *       &lt;/sequence>
 *       &lt;attribute name="sourceApp" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Viper"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="format" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="0.1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "trial"
})
@XmlRootElement(name = "emxDataFile")
public class EmxDataFile {

    @XmlElement(required = true)
    protected Trial trial;
    @XmlAttribute(name = "sourceApp", required = true)
    protected String sourceApp;
    @XmlAttribute(name = "format", required = true)
    protected BigDecimal format;

    /**
     * Gets the value of the trial property.
     * 
     * @return
     *     possible object is
     *     {@link Trial }
     *     
     */
    public Trial getTrial() {
        return trial;
    }

    /**
     * Sets the value of the trial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Trial }
     *     
     */
    public void setTrial(Trial value) {
        this.trial = value;
    }

    /**
     * Gets the value of the sourceApp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceApp() {
        return sourceApp;
    }

    /**
     * Sets the value of the sourceApp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceApp(String value) {
        this.sourceApp = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFormat(BigDecimal value) {
        this.format = value;
    }

}
