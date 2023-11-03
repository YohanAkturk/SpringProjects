package be.he2b.sport.business;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.he2b.sport.dto.RoomDto;
import be.he2b.sport.model.Reservation;
import be.he2b.sport.model.Room;
import be.he2b.sport.model.Sport;
import be.he2b.sport.repository.ReservationRepository;
import be.he2b.sport.repository.RoomRepository;
import be.he2b.sport.repository.SportRepository;

@Service
public class SportService {

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private SportRepository sportRepo;

    @Autowired
    private ReservationRepository reservationRepo;

    public List<Room> findAll() {
        return roomRepo.findAll();
    }

    public Room findRoomByName(String roomName) {
        return roomRepo.findByName(roomName);
    }

    public List<Sport> findAllSports(){
        return sportRepo.findAll();
    }

    public List<RoomDto> getRoomInformations(String sportCode){
        return roomRepo.getRoomInformations(sportCode);
    }

    public boolean insertReservation(String sportName, LocalDate date, String email){
        Sport sport = sportRepo.findByName(sportName);
        boolean isInserted = false;
        for (Room room : sport.getRooms()) {
            for(Reservation reservation : room.getReservations()){
                if(reservation.getDay() == date){
                    //L'id sera remplacé avec celui de la séquence, il ne sera donc pas de 0.
                    Reservation insertedReservation = new Reservation(0, email, date, room);
                    reservationRepo.save(insertedReservation);
                    isInserted = true;
                }
            }
        }
        return isInserted;
    }
}
