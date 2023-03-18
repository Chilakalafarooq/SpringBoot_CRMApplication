package farooq.WiproCRMApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import farooq.WiproCRMApp.Playload.LeadDto;
import farooq.WiproCRMApp.entites.Lead;
import farooq.WiproCRMApp.exception.LeadNotFoundException;
import farooq.WiproCRMApp.repository.LeadRepository;
@Service
public class LeadServiceImpl implements LeadService {
	
	private LeadRepository leadRepository;
	private ModelMapper mapper;
	public LeadServiceImpl(LeadRepository leadRepository, ModelMapper mapper) {
		super();
		this.leadRepository = leadRepository;
		this.mapper = mapper;
	}



	@Override
	public LeadDto saveOneLead(LeadDto leadDto) {
		Lead lead = mapToEntity(leadDto);
		Lead newLead = leadRepository.save(lead);
		LeadDto dto= mapToDto(newLead);
		return dto;
	}

	private LeadDto mapToDto(Lead newLead) {
		LeadDto map = mapper.map(newLead, LeadDto.class);
		Lead lead = new Lead
				();
		
		return map;
	}

	private Lead mapToEntity(LeadDto leadDto) {
		Lead leadmap = mapper.map(leadDto, Lead.class);
		return leadmap;
	}

	@Override
	public List<LeadDto> getallLeads() {
		List<Lead> findAll = leadRepository.findAll();
		return findAll.stream().map(map->mapToDto(map)).collect(Collectors.toList());
	}

	@Override
	public LeadDto getById(long id) {
		Lead lead =leadRepository.findById(id).orElseThrow(()-> new LeadNotFoundException("Lead","id",id));
		return mapToDto(lead);
	}


	@Override
	public Lead updateById(long id, LeadDto leadDto) {
		Lead leads =leadRepository.findById(id).
				orElseThrow(()-> new LeadNotFoundException("Lead","id",id));
		leads.setFirstName(leadDto.getFirstName());
		leads.setLastName(leadDto.getLastName());
		leads.setEmail(leadDto.getEmail());
		leads.setMobile(leadDto.getMobile());
		leads.setSource(leadDto.getSource());
		return leads;
	}

	@Override
	public void deleteById(long id) {
		Lead lead =leadRepository.findById(id).orElseThrow(()-> new LeadNotFoundException("Lead","id",id));
		leadRepository.delete(lead);
	}

	@Override
	public List<Lead> getPaginatedPosts(Integer pageNo, Integer pageSize, String sortby) {
		
		Pageable of = PageRequest.of(pageNo, pageSize, Sort.by(sortby));
		Page<Lead> paginated = leadRepository.findAll(of);
		return paginated.getContent();
	}



	}
	
	