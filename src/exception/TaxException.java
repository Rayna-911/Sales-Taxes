package exception;

public class TaxException extends Exception {
	private static final long serialVersionUID = 1L;
	/*The serialization runtime associates with each serializable class a version number, 
	 * called a serialVersionUID, which is used during deserialization to verify that the 
	 * sender and receiver of a serialized object have loaded classes for that object that 
	 * are compatible with respect to serialization. */
	public TaxException(){
		super();
	}
	public TaxException(String message) {
		System.out.println(message);
	}
}
