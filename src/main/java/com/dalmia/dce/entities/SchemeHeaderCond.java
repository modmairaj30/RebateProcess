package com.dalmia.dce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@NamedQuery(name = "User.findByName", query = "SELECT u FROM sch_header_det u WHERE LOWER(u.userName) = LOWER(?1)")
@Table(name = "sch_hdr_cond")
public class SchemeHeaderCond {
	
	@Id
	@Column(name = "sch_hdr_cond_id",length=11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schemeHdrCondId;
	
	@Column(name = "Header_Id")
	private String headerId;
	
	@Column(name = "FROM_VALUE")
	private double fromValue;
	
	@Column(name = "TO_VALUE")
	private double toValue;
	
	@Column(name = "RATE")
	private double rate;

	@Column(name = "C1_FROM")
	private double c1From;
	
	@Column(name = "C1_TO")
	private double c1To;
	
	@Column(name = "C1_VALUE")
	private double c1Value;
	
	@Column(name = "C2_FROM")
	private double c2From;
	
	@Column(name = "C2_TO")
	private double c2To;
	
	@Column(name = "C2_VALUE")
	private double c2Value;
	
	@Column(name = "C3_FROM")
	private double c3From;
	
	@Column(name = "C3_TO")
	private double c3To;
	
	@Column(name = "C3_VALUE")
	private double c3Value;
	
	@Column(name = "C4_FROM")
	private double c4From;
	
	@Column(name = "C4_TO")
	private double c4To;
	
	@Column(name = "C4_VALUE")
	private double c4Value;
	
	@Column(name = "C5_FROM")
	private double c5From;
	
	@Column(name = "C5_TO")
	private double c5To;
	
	@Column(name = "C5_VALUE")
	private double c5Value;

	public int getSchemeHdrCondId() {
		return schemeHdrCondId;
	}

	public void setSchemeHdrCondId(int schemeHdrCondId) {
		this.schemeHdrCondId = schemeHdrCondId;
	}

	public String getHeaderId() {
		return headerId;
	}

	public void setHeaderId(String headerId) {
		this.headerId = headerId;
	}

	public double getFromValue() {
		return fromValue;
	}

	public void setFromValue(double fromValue) {
		this.fromValue = fromValue;
	}

	public double getToValue() {
		return toValue;
	}

	public void setToValue(double toValue) {
		this.toValue = toValue;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getC1From() {
		return c1From;
	}

	public void setC1From(double c1From) {
		this.c1From = c1From;
	}

	public double getC1To() {
		return c1To;
	}

	public void setC1To(double c1To) {
		this.c1To = c1To;
	}

	public double getC1Value() {
		return c1Value;
	}

	public void setC1Value(double c1Value) {
		this.c1Value = c1Value;
	}

	public double getC2From() {
		return c2From;
	}

	public void setC2From(double c2From) {
		this.c2From = c2From;
	}

	public double getC2To() {
		return c2To;
	}

	public void setC2To(double c2To) {
		this.c2To = c2To;
	}

	public double getC2Value() {
		return c2Value;
	}

	public void setC2Value(double c2Value) {
		this.c2Value = c2Value;
	}

	public double getC3From() {
		return c3From;
	}

	public void setC3From(double c3From) {
		this.c3From = c3From;
	}

	public double getC3To() {
		return c3To;
	}

	public void setC3To(double c3To) {
		this.c3To = c3To;
	}

	public double getC3Value() {
		return c3Value;
	}

	public void setC3Value(double c3Value) {
		this.c3Value = c3Value;
	}

	public double getC4From() {
		return c4From;
	}

	public void setC4From(double c4From) {
		this.c4From = c4From;
	}

	public double getC4To() {
		return c4To;
	}

	public void setC4To(double c4To) {
		this.c4To = c4To;
	}

	public double getC4Value() {
		return c4Value;
	}

	public void setC4Value(double c4Value) {
		this.c4Value = c4Value;
	}

	public double getC5From() {
		return c5From;
	}

	public void setC5From(double c5From) {
		this.c5From = c5From;
	}

	public double getC5To() {
		return c5To;
	}

	public void setC5To(double c5To) {
		this.c5To = c5To;
	}

	public double getC5Value() {
		return c5Value;
	}

	public void setC5Value(double c5Value) {
		this.c5Value = c5Value;
	}
	
	

}