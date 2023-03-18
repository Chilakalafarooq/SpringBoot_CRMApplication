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

import farooq.WiproCRMApp.Playload.ContactDto;
import farooq.WiproCRMApp.Playload.LeadDto;
import farooq.WiproCRMApp.entites.Contact;
import farooq.WiproCRMApp.entites.Lead;
import farooq.WiproCRMApp.service.ContactService;
@RestController
@RequestMapping("/api/contact/crmapp")
public class ContactController {
	private ContactService contactService;
	private ModelMapper mapper;
	
public ContactController(ContactService contactService, ModelMapper mapper) {
		super();
		this.contactService = contactService;
		this.mapper = mapper;
	
}

    //http://localhost:8080/api/contact/crmapp
	@PostMapping 
    public ResponseEntity<Object> saveOneLead(@Valid @RequestBody ContactDto contactDto){
        return new ResponseEntity<Object>(contactService.saveOneContact(contactDto),HttpStatus.CREATED);
    }

  //http://localhost:8080/api/contact/crmapp
  @GetMapping
  public List<ContactDto> getallContacts(){
	  return contactService.getallContacts();
  }
  //http://localhost:8080/api/contact/crmapp/7
  @GetMapping("/{id}")
  public ResponseEntity<ContactDto> getById(@PathVariable("id")long id){
	  return new ResponseEntity<>(contactService.getById(id),HttpStatus.OK);
	  
  }
  //http://localhost:8080/api/contact/crmapp/1
  @PutMapping("/{id}")
  
  public ResponseEntity<Contact> updateById(@PathVariable("id")long id,@RequestBody ContactDto  contactDto){
	  return new ResponseEntity<>(contactService.updateById(id,contactDto),HttpStatus.OK);
  
  }
  
  //http://localhost:8080/api/contact/crmapp/1
  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteById(@PathVariable(value = "id")long id){
	  contactService.deleteById(id);
		return new ResponseEntity<Object>("Contact entity deleted successfully.",HttpStatus.OK);
	}
  //http://localhost:8080/api/contact/crmapp/page?pageNo={}&pageSize={}
  @GetMapping("/page")
  
  public ResponseEntity<List<Contact>> getallLeadsPaginated(
		  @RequestParam(defaultValue = "0",required = false)Integer pageNo,
		  @RequestParam(defaultValue = "10",required = false)Integer pageSize,
		  @RequestParam(defaultValue = "id",required = false)String sortby){
	  List<Contact> paginatedPosts = contactService.getPaginatedPosts(pageNo, pageSize, sortby);
      return ResponseEntity.ok(paginatedPosts);
  }
  }
  
