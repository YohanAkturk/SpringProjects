package be.he2b.sport.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.he2b.sport.business.SportService;
import be.he2b.sport.dto.RoomDto;

@RestController
@RequestMapping("/api")
public class SportRestController {
    
    @Autowired
    private SportService sportService;

    @GetMapping("/{sportCode}")
    public ResponseEntity<List<RoomDto>> getServiceWeb(@PathVariable("sportCode") String sportCode) {
        System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee => " + sportCode);
        try {
            List<RoomDto> roomDtos = sportService.getRoomInformations(sportCode);
            return new ResponseEntity<>(roomDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
