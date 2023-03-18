package farooq.WiproCRMApp.exception;

public class BillNotFoundedException extends RuntimeException {
    
    public BillNotFoundedException(Long id) {
        super("Bill with id " + id + " not found.");
    }

	public BillNotFoundedException(String string, String string2, long id) {
	}
}
