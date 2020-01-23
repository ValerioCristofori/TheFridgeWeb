package logic.entity;

public class Food {
	private String name;
	private int quantity;
	private String expirationDate;
	
	public Food() {
		this.name = "";
		this.quantity = 0;
		this.expirationDate = null;
	}
	
	public Food(String name, int quantity, String expirationDate) {
		this.name = name;
		this.quantity = quantity;
		this.expirationDate = expirationDate;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the expirationDate
	 */
	public String getExpirationDate() {
		return expirationDate;
	}
	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
}
