package g56514.webg5.chapterNineTeen.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g56514.webg5.chapterNineTeen.model.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByName(String name){
        return userRepository.findByName(name);
    }
    
}
