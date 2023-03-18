package farooq.WiproCRMApp.service;



import java.util.List;

import farooq.WiproCRMApp.Playload.LeadDto;
import farooq.WiproCRMApp.entites.Lead;

public interface LeadService {

	LeadDto saveOneLead(LeadDto leadDto);

	List<LeadDto> getallLeads();

	LeadDto getById(long id);

	Lead updateById(long id, LeadDto leadDto);

	void deleteById(long id);


	List<Lead> getPaginatedPosts(Integer pageNo, Integer pageSize, String sortby);




	
}
