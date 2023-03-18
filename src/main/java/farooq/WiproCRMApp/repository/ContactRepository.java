package farooq.WiproCRMApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import farooq.WiproCRMApp.entites.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
