package g56514.webg5.helloWorldRest.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Info {
    private String message;
    private Date date;
}
