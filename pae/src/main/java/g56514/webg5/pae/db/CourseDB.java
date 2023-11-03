package g56514.webg5.pae.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import g56514.webg5.pae.model.Course;

public interface CourseDB extends CrudRepository<Course, String>{

    List<Course> findByLibelle(String libelle);
}
