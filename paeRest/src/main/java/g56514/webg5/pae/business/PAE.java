package g56514.webg5.pae.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g56514.webg5.pae.model.Course;

@Service
public class PAE {
    
    Course introductions = new Course("INT1", "Introductions", 10);
    Course mathématiques = new Course("MAT1", "Mathématiques II", 3);
    Course anglais = new Course("CAI1", "Anglais I", 2);
    Course développement1 = new Course("DEV1", "Développement I", 10);
    Course développement2 = new Course("DEV2", "Développement II", 10);
    Course développementWeb = new Course("WEBG2", "Développement web I", 5);

    public List<Course> getCourses(){
        List<Course> courses = new ArrayList<>();
        courses.add(introductions);
        courses.add(mathématiques);
        courses.add(anglais);
        courses.add(développement1);
        courses.add(développement2);
        courses.add(développementWeb);

        return courses;
    }

    public List<Course> getCourse(String id){
        List<Course> courses = new ArrayList<>();
        courses.add(introductions);
        courses.add(mathématiques);
        courses.add(anglais);
        courses.add(développement1);
        courses.add(développement2);
        courses.add(développementWeb);

        List<Course> course = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getLibelle().equals(id)){
                course.add(courses.get(i));
            }
        }
        
        return course;
    }
}
