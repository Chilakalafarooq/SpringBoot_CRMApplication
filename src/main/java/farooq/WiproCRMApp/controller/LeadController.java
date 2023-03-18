package farooq.WiproCRMApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import farooq.WiproCRMApp.Playload.LeadDto;
import farooq.WiproCRMApp.entites.Lead;
import farooq.WiproCRMApp.service.LeadService;



@RestController
@RequestMapping("/api/lead/crmapp")
public class LeadController {
   
    private LeadService leadService;
    
    private ModelMapper mapper;
    
    
  
    
    public LeadController(LeadService leadService, ModelMapper mapper) {
		super();
		this.leadService = leadService;
		this.mapper = mapper;
	}
    //http://localhost:8080/api/lead/crmapp
	@PostMapping 
    public ResponseEntity<Object> saveOneLead(@Valid @RequestBody LeadDto leadDto){
        return new ResponseEntity<Object>(leadService.saveOneLead(leadDto),HttpStatus.CREATED);
    }

  //http://localhost:8080/api/lead/crmapp
  @GetMapping
  public List<LeadDto> getallLeads(){
	  return leadService.getallLeads();
  }
  //http://localhost:8080/api/lead/crmapp/1
  @GetMapping("/{id}")
  public ResponseEntity<LeadDto> getById(@PathVariable("id")long id){
	  return new ResponseEntity<>(leadService.getById(id),HttpStatus.OK);
	  
  }
  //http://localhost:8080/api/lead/crmapp/1
  @PutMapping("/{id}")
  
  public ResponseEntity<Lead> updateById(@PathVariable("id")long id,@RequestBody LeadDto leadDto){
	  return new ResponseEntity<>(leadService.updateById(id,leadDto),HttpStatus.OK);
  
  }
  
  //http://localhost:8080/api/lead/crmapp/1
  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteById(@PathVariable(value = "id")long id){
	  leadService.deleteById(id);
		return new ResponseEntity<Object>("Lead entity deleted successfully.",HttpStatus.OK);
	}
  //http://localhost:8080/api/lead/crmapp/page?pageNo={}&pageSize={}
  @GetMapping("/page")
  
  public ResponseEntity<List<Lead>> getallLeadsPaginated(
		  @RequestParam(defaultValue = "0",required = false)Integer pageNo,
		  @RequestParam(defaultValue = "10",required = false)Integer pageSize,
		  @RequestParam(defaultValue = "id",required = false)String sortby){
	  List<Lead> paginatedPosts = leadService.getPaginatedPosts(pageNo, pageSize, sortby);
      return ResponseEntity.ok(paginatedPosts);

  }
  
  
}