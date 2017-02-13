package com.appdirect.hackday.ivanka.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Product information used for the listing on the marketplace
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@XmlRootElement(name = "application") @XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductListingWS implements Serializable {
	private static final long serialVersionUID = 3433460080769094665L;

	/**
	 * URL to get product detail
	 */
	@XmlAttribute private String href;

	/**
	 * ID
	 */
	private Long id;

	/**
	 * Unique identifier
	 */
	private String uuid;

	/**
	 * URL to product profile
	 */
	private String url;

	/**
	 * Name
	 */
	private String name;

	/**
	 * Product type
	 */
	private String productType;

	/**
	 * Icon URL
	 */
	private String iconUrl;

	/**
	 * Profile logo URL
	 */
	private String profileLogoUrl;

	/**
	 * Icon Srcset
	 */
	private Map<String, String> iconSrcset = new HashMap<>();

	/**
	 * Profile logo Srcset
	 */
	private Map<String, String> profileLogoSrcset = new HashMap<>();

	/**
	 * Description
	 */
	private String description;

	/**
	 * Overview
	 */
	private String overview;

	/**
	 * Starting price
	 */
	private String startingPrice;

	/**
	 * Starting prices per currency on channel
	 */
	private ChannelStartingPrice channelStartingPrice;

	/**
	 * Billing frequency
	 */
	private String billingFrequency;

	/**
	 * Publication date
	 */
	private Date publishedOn;

	/**
	 * Developer name
	 */
	private String developerName;

	/**
	 * Vendor company name
	 */
	private String vendorName;

	/**
	 * User-submitted total rating
	 */
	private Integer rating;

	/**
	 * Number of ratings
	 */
	private Integer numRatings;

	/**
	 * Must show the rating
	 */
	private boolean showRating;

	/**
	 * Overview image URL
	 */
	private String overviewImageUrl;

	/**
	 * Overview image Srcset
	 */
	private Map<String, String> overviewImageSrcset = new HashMap<>();

	/**
	 * Short description
	 */
	private String blurb;

	/**
	 * Is buyable
	 */
	private boolean buyable;

	/**
	 * Is free
	 */
	private boolean free;

	/**
	 * Is free trial or edition present
	 */
	private boolean freeTrialOrEditionPresent;

	/**
	 * Is a referable product
	 */
	private boolean referable;

	/**
	 * Has lync to phone add-on
	 */
	private boolean hasLyncToPhone;

	/**
	 * Download file size for downloadable product
	 */
	private Long downloadFileSize;

	/**
	 * Hide pricings
	 */
	private boolean hidePricings;

	/**
	 * Collect lead
	 */
	private boolean collectLeads;

	/**
	 * Is an add-on product
	 */
	private boolean addon;

	// From AppChannel.
	/**
	 * Is featured
	 */
	private boolean featured;

	/**
	 * Featured slider position
	 */
	private Integer featuredSliderPosition;

	/**
	 * Is populare
	 */
	private boolean popular;

	/**
	 * Poplarity rank
	 */
	private Integer popularity;

	/**
	 * Is staff pick
	 */
	private boolean staffPick;

	/**
	 * Staff pick slider position
	 */
	private Integer staffPickSliderPosition;

	/**
	 * Last modified date
	 */
	private Date lastModified;

	/**
	 * Sort rank
	 */
	private Integer sortRank;

	/**
	 * List of bundle URLs
	 */
	@XmlElementWrapper(name = "bundleUrls") @XmlElement(name = "bundleUrl")
	private Set<String> bundleUrls = new HashSet<>();

	/**
	 * List of supported languages
	 */
	@XmlElementWrapper(name = "supportedLanguages") @XmlElement(name = "language")
	private Set<String> supportedLanguages = new TreeSet<>();
}
