package be.he2b.scrum.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import be.he2b.scrum.dto.StateProject;
import be.he2b.scrum.model.Project;

public interface ProjectRepository extends JpaRepository<Project, String>{
    
    public Project findByName(String name);

}
