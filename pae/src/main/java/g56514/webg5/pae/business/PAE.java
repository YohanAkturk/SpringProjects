package g56514.webg5.pae.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g56514.webg5.pae.db.CourseDB;
import g56514.webg5.pae.db.EtudiantDB;
import g56514.webg5.pae.model.Course;
import g56514.webg5.pae.model.Etudiant;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class PAE {

    @Autowired
    private CourseDB courseDB;

    @Autowired
    private EtudiantDB etudiantDB;

    // avant base de données
    // public List<Course> getCourses(){
    // Course introductions = new Course("INT1", "Introductions", 10);
    // Course mathématiques = new Course("MAT1", "Mathématiques II", 3);
    // Course anglais = new Course("CAI1", "Anglais I", 2);
    // Course développement1 = new Course("DEV1", "Développement I", 10);
    // Course développement2 = new Course("DEV2", "Développement II", 10);
    // Course développementWeb = new Course("WEBG2", "Développement web I", 5);

    // List<Course> courses = new ArrayList<>();
    // courses.add(introductions);
    // courses.add(mathématiques);
    // courses.add(anglais);
    // courses.add(développement1);
    // courses.add(développement2);
    // courses.add(développementWeb);

    // return courses;
    // }

    // avec base de données
    public Iterable<Course> getCourses() {
        Iterable<Course> courses = courseDB.findAll();
        courses.forEach(System.out::println);
        return courses;
    }

    public Iterable<Course> insertCourseDB(Course course) {
        System.out.println(course);
        courseDB.save(course);
        Iterable<Course> courses = courseDB.findAll();
        courses.forEach(System.out::println);
        return courses;
    }

    public Iterable<Etudiant> getEtudiants() {
        Iterable<Etudiant> etudiants = etudiantDB.findAll();
        etudiants.forEach(System.out::println);
        return etudiants;
    }

    public Iterable<Etudiant> insertEtudiantDB(int matricule) {
        Etudiant etudiant = etudiantDB.findById(matricule).get();
        etudiantDB.save(etudiant);
        Iterable<Etudiant> etudiants = etudiantDB.findAll();
        etudiants.forEach(System.out::println);
        return etudiants;
    }

    public void insertEtudiantToCourse(String courseId, int etudiantMatricule) {
        Optional<Etudiant> etudiant = etudiantDB.findById(etudiantMatricule);
        if (etudiant.get() != null) {
            Course course = courseDB.findById(courseId).get();
            course.getEtudiants().add(etudiant.get());
            System.out.println("!!! ETUDIANT MIS DANS LA LISTE DU COURS EN DB !!!");
            courseDB.save(course);
        } else {
            System.out.println("!!! ETUDIANT N'EXISTE PAS !!!");
        }
    }

    public void insertCourseForStudent(String courseId, int etudiantMatricule) {
        Etudiant etudiant = etudiantDB.findById(etudiantMatricule).get();
        Course course = courseDB.findById(courseId).get();
        if (etudiant != null && course != null) {
            etudiant.getCourses().add(course);
            System.out.println("!!! COURSE MIS DANS LA LISTE DE L'ETUDIANT EN DB !!!");
            etudiantDB.save(etudiant);
        } else {
            System.out.println("!!! COURSE N'EXISTE PAS !!!");
        }
    }

    public List<Etudiant> getEtudiantsForGivenCourse(String courseId) {
        System.out.println(courseId);
        Optional<Course> course = courseDB.findById(courseId);
        System.out.println(courseDB.findById(courseId));
        return course.get().getEtudiants();
    }

    public Course getCourseById(String id) {
        System.out.println(id);
        System.out.println(courseDB.findById(id).get());
        return courseDB.findById(id).get();
    }

    public List<Course> getCoursesForGivenEtudiant(int etudiantId) {
        System.out.println(etudiantId);
        Optional<Etudiant> etudiant = etudiantDB.findById(etudiantId);
        System.out.println(etudiantDB.findById(etudiantId));
        return etudiant.get().getCourses();
    }

    public Etudiant getEtudiantById(int id) {
        System.out.println(id);
        System.out.println(etudiantDB.findById(id).get());

        // Test JPQL query noms + nbEcts
        List<Object[]> recs = etudiantDB.getNomEtEcts();
        System.out.println("HELOyy => " + recs);
        for (Object[] elt : recs) {
            System.out.println("elt : " + elt[0]);
            System.out.println("elt : " + elt[1]);
        }

        //Test JPQL query étudiants + d'ects qu'une valeur donnée en paramètre
        List<Object[]> recsCondition = etudiantDB.getNomEtEctsPlusQue(new Long(10));
        System.out.println("HELOkkk => " + recsCondition);
        for (Object[] eltt : recsCondition) {
            System.out.println("elt : " + eltt[0]);
            System.out.println("elt : " + eltt[1]);
        }
        return etudiantDB.findById(id).get();
    }

    public List<Course> getCourseByLibelle(String libelle) {
        System.out.println("===> " + courseDB.findByLibelle(libelle));
        return courseDB.findByLibelle(libelle);
    }

    public Iterable<Etudiant> getEtudiantByNom(String nom) {
        return etudiantDB.findByNom(nom);
    }

    public List<Object> getEtudiantByNameTestJPQL(String nom) {
        List<Object> etudiants = etudiantDB.getByLeNom(nom);
        return etudiants;
    }
}
