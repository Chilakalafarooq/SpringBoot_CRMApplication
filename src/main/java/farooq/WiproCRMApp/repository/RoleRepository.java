package farooq.WiproCRMApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import farooq.WiproCRMApp.entites.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
