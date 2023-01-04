package gestion.evenement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.evenement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String Username);

}