package farooq.WiproCRMApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import farooq.WiproCRMApp.Playload.BillingDto;
import farooq.WiproCRMApp.Playload.ContactDto;
import farooq.WiproCRMApp.entites.Billing;
import farooq.WiproCRMApp.entites.Contact;
import farooq.WiproCRMApp.service.BillingService;
import farooq.WiproCRMApp.service.ContactService;
@RestController
@RequestMapping("/api/billing/crmapp")
public class BillingController {

private BillingService billingService;
		private ModelMapper mapper;
	    public BillingController(BillingService billingService, ModelMapper mapper) {
			super();
			this.billingService = billingService;
			this.mapper = mapper;
		}

		//http://localhost:8080/api/billing/crmapp
		@PostMapping 
	    public ResponseEntity<Object> saveOneLead(@Valid @RequestBody BillingDto billingDto){
	        return new ResponseEntity<Object>(billingService.saveOnebilling(billingDto),HttpStatus.CREATED);
	    }

	  //http://localhost:8080/api/contact/crmapp
	  @GetMapping
	  public List<BillingDto> getallContacts(){
		  return billingService.getallBilling();
	  }
	  //http://localhost:8080/api/billing/crmapp/7
	  @GetMapping("/{id}")
	  public ResponseEntity<BillingDto> getById(@PathVariable("id")long id){
		  return new ResponseEntity<>(billingService.getById(id),HttpStatus.OK);
		  
	  }
	  //http://localhost:8080/api/billing/crmapp/1
	  @PutMapping("/{id}")
	  
	  public ResponseEntity<Billing> updateById(@PathVariable("id")long id,@RequestBody BillingDto  billingDto){
		  return new ResponseEntity<>(billingService.updateById(id,billingDto),HttpStatus.OK);
	  
	  }
	  
	  //http://localhost:8080/api/billing/crmapp/1
	  @DeleteMapping("/{id}")
	  public ResponseEntity<Object> deleteById(@PathVariable(value = "id")long id){
		  billingService.deleteById(id);
			return new ResponseEntity<Object>("Billing entity deleted successfully.",HttpStatus.OK);
		}
	  //http://localhost:8080/api/billing/crmapp/page?pageNo={}&pageSize={}
	  @GetMapping("/page")
	  
	  public ResponseEntity<List<Billing>> getallLeadsPaginated(
			  @RequestParam(defaultValue = "0",required = false)Integer pageNo,
			  @RequestParam(defaultValue = "10",required = false)Integer pageSize,
			  @RequestParam(defaultValue = "id",required = false)String sortby){
		  List<Billing> paginatedPosts = billingService.getPaginatedBilling(pageNo, pageSize, sortby);
	      return ResponseEntity.ok(paginatedPosts);
	  }
	  }
	  
