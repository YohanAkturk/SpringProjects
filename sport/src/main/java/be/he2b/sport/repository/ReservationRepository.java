package be.he2b.sport.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import be.he2b.sport.model.Reservation;
import be.he2b.sport.model.Room;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

    public Reservation findByRoomOrDay(Room room, LocalDate day);
    
}
