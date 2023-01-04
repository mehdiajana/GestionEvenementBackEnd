package gestion.evenement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import gestion.evenement.model.Evenement;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {

    @Query(value = "SELECT e.* "
            + " FROM evenement e,user_evenements ue "
            + " WHERE e.id=ue.evenements_id and"
            + " ue.user_id= ?1"
            ,nativeQuery = true)
    List<Evenement> mydemandes(Long id);

    @Modifying
    @Transactional
    @Query(value = "Delete "
            + " FROM user_evenements "
            + " WHERE evenements_id= ?1"
            ,nativeQuery = true)
    void deleteev(Long id);



}
