package be.he2b.sport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import be.he2b.sport.dto.RoomDto;
import be.he2b.sport.model.Room;

public interface RoomRepository extends JpaRepository<Room, String>{
    
    @Query("SELECT NEW be.he2b.sport.dto.RoomDto(r.code, r.name, res.email) FROM Room r JOIN r.sports sp JOIN r.reservations res  WHERE sp.code = :sportCode GROUP BY r.code, r.name, res.email  HAVING COUNT(res) > 0")
    public List<RoomDto> getRoomInformations(String sportCode);

    public Room findByName(String name);

}
