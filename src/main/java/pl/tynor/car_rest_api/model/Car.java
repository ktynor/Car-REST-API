package pl.tynor.car_rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.tynor.car_rest_api.model.enums.Color;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {

    private Long id;
    private String make;
    private String model;
    private Color color;

}
