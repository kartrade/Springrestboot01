package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/payment")
public class ControllerRequest {
	private final String sharedKey = "SHARED_KEY";
	 private static final String SUCCESS_STATUS = "success";
	 private static final String ERROR_STATUS = "error";
	 private static final int CODE_SUCCESS = 100;
	 private static final int AUTH_FAILURE = 102;
	 
	 @RequestMapping(value="/forusers", method=RequestMethod.POST)
	 public ResponseEntity<BaseResponse> getPaymentInfo(@RequestParam (value="id") String key,@RequestBody PaymentRequest paymentRequest) 
			 throws PaymentRequestException{
		 System.out.println(" the reste request came");
		 BaseResponse br= new BaseResponse();
		 if(key.equalsIgnoreCase("ravi")){
			 br.setCode(1);
			 br.setStatus("OK");
		 }else if(key.equalsIgnoreCase("SHARED_KEY")){
			 br.setCode(2);
			 br.setStatus("Not OK");
		 }else{
			 throw new NullPointerException();
			// throw new PaymentRequestException(" theis request is not ok");
		 }
		 
		return new ResponseEntity<BaseResponse>(br,HttpStatus.OK);
		 
	 }
	
	 @ExceptionHandler(PaymentRequestException.class)
	public ResponseEntity<ErrorResponse> sendErrorResponse(Exception e){
		 ErrorResponse ers= new ErrorResponse();
		 ers.setErrorCode(405);
		 ers.setMessage(e.getMessage());
		return  new ResponseEntity<ErrorResponse>(ers,HttpStatus.BAD_REQUEST);
	}

}
