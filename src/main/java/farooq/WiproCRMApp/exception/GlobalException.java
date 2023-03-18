package farooq.WiproCRMApp.exception;

import java.util.Date;

import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(LeadNotFoundException.class)
	public ResponseEntity<BugDetail> handlerLeadNotFoundException(LeadNotFoundException exception,WebRequest request){
		BugDetail detail= new BugDetail(new Date(),exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<BugDetail>(detail,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ContactNotFoundException.class)
	public ResponseEntity<BugDetail> handlerContactNotFoundException(ContactNotFoundException exception,WebRequest request){
		BugDetail detail= new BugDetail(new Date(),exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<BugDetail>(detail,HttpStatus.BAD_REQUEST);
	
}
	@ExceptionHandler(BillNotFoundedException.class)
	public ResponseEntity<BugDetail> handlerBillNotFoundedException(BillNotFoundedException exception,WebRequest request){
		BugDetail detail= new BugDetail(new Date(),exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<BugDetail>(detail,HttpStatus.BAD_REQUEST);
	}

}