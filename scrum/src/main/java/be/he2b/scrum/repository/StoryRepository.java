package be.he2b.scrum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import be.he2b.scrum.dto.StateProject;
import be.he2b.scrum.model.Story;

public interface StoryRepository extends JpaRepository<Story, Integer>{

    public List<Story> findBySprintProjectName(String name);

    @Query("SELECT NEW be.he2b.scrum.dto.StateProject(st.sprint.project.name, count(distinct st.sprint), count(st)) FROM Story st WHERE st.sprint.project.name like :lettre% Group by st.sprint.project.name")
    public List<StateProject> getStateProject(String lettre);
    
}
