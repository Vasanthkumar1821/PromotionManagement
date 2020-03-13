package com.avps.Promotion.Entity;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "promotion")
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "promotionname")
	private String promotionName;
	@Column(name = "promotionstate")
	private String promotionState;
	@Column(name = "promotionvalidfrom")
	private Date promotionValidFrom;
	@Column(name = "promotionexpiresat")
	private Date promotionExpiresAt;
	@Column(name = "discountamount")
	private double discountAmount;

	public Promotion() {
		// TODO Auto-generated constructor stub
	}
	public Promotion(int id, String promotionName, String promotionState, Date promotionValidFrom,
			Date promotionExpiresAt, double discountAmount) {
		this.id = id;
		this.promotionName = promotionName;
		this.promotionState = promotionState;
		this.promotionValidFrom = promotionValidFrom;
		this.promotionExpiresAt = promotionExpiresAt;
		this.discountAmount = discountAmount;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getPromotionState() {
		return promotionState;
	}

	public void setPromotionState(String promotionState) {
		this.promotionState = promotionState;
	}

	public Date getPromotionValidFrom() {
		return promotionValidFrom;
	}

	public void setPromotionValidFrom(Date promotionValidFrom) {
		this.promotionValidFrom = promotionValidFrom;
	}

	public Date getPromotionExpiresAt() {
		return promotionExpiresAt;
	}

	public void setPromotionExpiresAt(Date promotionExpiresAt) {
		this.promotionExpiresAt = promotionExpiresAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", promotionName=" + promotionName + ", promotionState=" + promotionState
				+ ", promotionValidFrom=" + promotionValidFrom + ", promotionExpiresAt=" + promotionExpiresAt
				+ ", discountAmount=" + discountAmount + "]";
	}

}
