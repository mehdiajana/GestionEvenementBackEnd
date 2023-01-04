package gestion.evenement.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import gestion.evenement.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String Name);
}