package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    private Engine engine;
    private String brand;
    private String type;
    private Date buyDate;
    private List<Human> humans;

}
