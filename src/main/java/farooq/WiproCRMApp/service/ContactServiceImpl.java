package farooq.WiproCRMApp.service;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import farooq.WiproCRMApp.Playload.ContactDto;
import farooq.WiproCRMApp.entites.Contact;
import farooq.WiproCRMApp.entites.Lead;
import farooq.WiproCRMApp.exception.LeadNotFoundException;
import farooq.WiproCRMApp.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService{
private ContactRepository contactRepository;
private ModelMapper mapper;
	public ContactServiceImpl(ContactRepository contactRepository, ModelMapper mapper) {
	super();
	this.contactRepository = contactRepository;
	this.mapper = mapper;
}

	@Override
	public List<ContactDto> getallContacts() {
		List<Contact> findAll = contactRepository.findAll();
		return findAll.stream().map(map->mapToDto(map)).collect(Collectors.toList());
	}

	@Override
	public ContactDto getById(long id) {
		Contact  contact =contactRepository.findById(id).orElseThrow(()-> new LeadNotFoundException("Contact","id",id));
		return mapToDto(contact);
	}

	@Override
	public ContactDto saveOneContact(ContactDto contactDto) {
		Contact contact = mapToEntity(contactDto);
		Contact newcontact = contactRepository.save(contact);
		ContactDto dto =mapToDto(newcontact);
		return dto;
	}

	
	private ContactDto mapToDto(Contact newcontact) {
		ContactDto map = mapper.map(newcontact, ContactDto.class);
		return map;
	}

	private Contact mapToEntity(ContactDto contactDto) {
		Contact maps = mapper.map(contactDto, Contact.class);
		return maps;
	}

	@Override
	public Contact updateById(long id, ContactDto contactDto) {
		Contact  contact =contactRepository.findById(id).orElseThrow(()-> new LeadNotFoundException("Contact","id",id));
contact.setEmail(contactDto.getEmail());
contact.setFirstName(contactDto.getFirstName());
contact.setLastName(contactDto.getLastName());
contact.setMobile(contactDto.getMobile());
		return contact;
	}

	@Override
	public void deleteById(long id) {
		Contact  contact =contactRepository.findById(id).orElseThrow(()-> new LeadNotFoundException("Contact","id",id));
		contactRepository.delete(contact);
	}

	@Override
	public List<Contact> getPaginatedPosts(Integer pageNo, Integer pageSize, String sortby) {
		Pageable of = PageRequest.of(pageNo, pageSize, Sort.by(sortby));
		Page<Contact> paginated = contactRepository.findAll(of);
		return paginated.getContent();
	}

}
