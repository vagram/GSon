import Entity.Car;
import Entity.Engine;
import Entity.Human;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import deserializator.CarDeserializator;
import deserializator.EngineDeserializator;
import deserializator.HumanDeserializator;
import serializations.CarSerializator;
import serializations.EngineSerializator;
import serializations.HumanSerializator;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Human Oleg = new Human("Oleg",40);
        Human Ivan = new Human("Ivan",45);
        List<Human> humans = new ArrayList<>();
        humans.add(Oleg);
        humans.add(Ivan);
        Engine engine = new Engine("BMW Engine","BMW",3.0,"Motorsport");
        Car car = new Car(engine,"BMW M3","Sedan",new Date(),humans);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Engine.class, new EngineSerializator())
                .registerTypeAdapter(Car.class, new CarSerializator())
                .registerTypeAdapter(Human.class, new HumanSerializator())
                .registerTypeAdapter(Human.class, new HumanDeserializator())
                .registerTypeAdapter(Engine.class, new EngineDeserializator())
                .registerTypeAdapter(Car.class, new CarDeserializator())
                .create();
        String carStr = gson.toJson(car);
        System.out.println(carStr);

        car = gson.fromJson(carStr, Car.class);
        System.out.println(car);

    }
}
