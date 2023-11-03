package be.he2b.scrum.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.he2b.scrum.dto.StateProject;
import be.he2b.scrum.model.Project;
import be.he2b.scrum.model.Sprint;
import be.he2b.scrum.model.Story;
import be.he2b.scrum.repository.ProjectRepository;
import be.he2b.scrum.repository.SprintRepository;
import be.he2b.scrum.repository.StoryRepository;
import lombok.NoArgsConstructor;

@Service
public class ScrumService {

    @Autowired
    private StoryRepository storyRepo;

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private ProjectRepository projectRepo;

    public List<Story> getStoriesOfProject(String name){
        List<Story> stories = storyRepo.findBySprintProjectName(name);
        System.out.println("POPPP" + stories);
        return storyRepo.findBySprintProjectName(name);
    }

    public List<StateProject> getStateProject(String lettre){
        //StateProject tmp = new StateProject("projet", 1, 2);
        //System.out.println("hereeee" + tmp);


        // List<StateProject> tmp = storyRepo.getStateProject(lettre);
        // System.out.println("TESTTTTT" + tmp);
        return storyRepo.getStateProject(lettre);
    }

    public List<Project> getAllProjects(){
        return projectRepo.findAll();
    }

    public Project getProjectWithName(String name){
        return projectRepo.findByName(name);
    }

    public void insertStory(String name, String title, int estimate){
        Sprint sprint = sprintRepository.findTopByProjectNameOrderByIdDesc(name);
        Story story = new Story(title, estimate, sprint);
        storyRepo.save(story);
    }
    
    public void insertStory(Story story){
        storyRepo.save(story);
    }
}
