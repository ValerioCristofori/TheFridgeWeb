package logic.implementation.exceptions;

public class DuplicatedFoodException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String nameDuplicated;
	private final int quantityDuplicated;
	
	public DuplicatedFoodException(String name, int quantity) {
		this.nameDuplicated = name;
		this.quantityDuplicated = quantity;
	}

	/**
	 * @return the nameDuplicated
	 */
	public String getNameDuplicated() {
		return nameDuplicated;
	}

	/**
	 * @return the quantityDuplicated
	 */
	public int getQuantityDuplicated() {
		return quantityDuplicated;
	}


}
