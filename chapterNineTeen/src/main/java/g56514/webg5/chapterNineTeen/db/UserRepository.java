package g56514.webg5.chapterNineTeen.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import g56514.webg5.chapterNineTeen.model.User;

public interface UserRepository extends JpaRepository<User, String>{

    public User findByName(String name);

    // from User = Entity, not Table name 
    @Query("SELECT u FROM User u WHERE length(u.login)>12")
    public List<User> findByLongLogin();
}
