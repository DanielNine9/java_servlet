package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public static int auto = 0;
	public String name;
	public String image;
	public double price;
	public double discount;
	public String date;
	public double currentPrice = 0.0;
	public int id;
	public int quantity;
	public double getCurrentPrice() {
		return currentPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product(String name, String image, double price, double discount) {
		super();
		this.id = ++Product.auto;
		this.name = name;
		this.image = image;
		this.price = price;
		this.discount = discount;
		this.quantity = 0;
		
		this.currentPrice = (this.price - (this.price * this.discount));
		Date dateNotFormat = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		this.date = sdf.format(dateNotFormat);
	}

}
