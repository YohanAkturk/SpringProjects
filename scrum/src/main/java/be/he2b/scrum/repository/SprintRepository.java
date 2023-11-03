package be.he2b.scrum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import be.he2b.scrum.model.Sprint;

public interface SprintRepository extends JpaRepository<Sprint, Integer>{
    
    public Sprint findTopByProjectNameOrderByIdDesc(String name);

}
