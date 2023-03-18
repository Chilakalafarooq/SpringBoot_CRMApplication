package farooq.WiproCRMApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import farooq.WiproCRMApp.entites.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
}
