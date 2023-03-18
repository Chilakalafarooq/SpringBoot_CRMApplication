package farooq.WiproCRMApp.service;

import java.util.List;
import farooq.WiproCRMApp.Playload.ContactDto;
import farooq.WiproCRMApp.entites.Contact;

public interface ContactService {

	

	List<ContactDto> getallContacts();

	ContactDto getById(long id);

	ContactDto saveOneContact(ContactDto contactDto);

	Contact updateById(long id, ContactDto contactDto);

	void deleteById(long id);

	List<Contact> getPaginatedPosts(Integer pageNo, Integer pageSize, String sortby);



}
