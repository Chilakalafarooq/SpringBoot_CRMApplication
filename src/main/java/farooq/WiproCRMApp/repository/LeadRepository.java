package farooq.WiproCRMApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import farooq.WiproCRMApp.entites.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
}

