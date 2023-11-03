package be.he2b.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.he2b.sport.model.Sport;

public interface SportRepository extends JpaRepository<Sport, String>{
    
    public Sport findByName(String name);
}
