package logic.implementation.exceptions;

public class FridgeIdAlreadyExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int newId;
	
	public FridgeIdAlreadyExistException( int id ) {
		this.newId = id + 1;
	}

	/**
	 * @return the newId
	 */
	public int getNewId() {
		return newId;
	}

}
