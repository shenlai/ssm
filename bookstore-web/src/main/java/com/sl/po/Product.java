package com.sl.po;

import java.math.BigDecimal;

public class Product {
	private int Id;
	private String Name;
	private String Description;
	private BigDecimal UnitPrice;
	private String ImageUrl;
	private Boolean IsNew;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public BigDecimal getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(BigDecimal unitprice) {
		this.UnitPrice = unitprice;
	}

	public String getImageUrl() {
		return Name;
	}

	public void setImageUrl(String imageurl) {
		this.ImageUrl = imageurl;
	}

	public boolean getIsNew() {
		return IsNew;
	}

	public void setIsNew(boolean isnew) {
		this.IsNew = isnew;
	}

	@Override
    public String toString() {
        return "Product [id=" + Id + ", Name=" + Name + ", Description=" + Description
                + ", UnitPrice=" + UnitPrice + ", ImageUrl=" + ImageUrl + ", IsNew=" + IsNew+ "]";
    }
}

