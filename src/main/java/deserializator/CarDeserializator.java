package deserializator;

import Entity.Car;
import Entity.Engine;
import Entity.Human;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CarDeserializator implements JsonDeserializer<Car> {
    @Override
    public Car deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        Car car = new Car();
        JsonObject dataObject = jsonElement.getAsJsonObject();
        car.setBrand(dataObject.get("Car_brand").getAsString());
        car.setType(dataObject.get("type").getAsString());
        car.setEngine(context.<Engine>deserialize(dataObject.get("engine"), Engine.class));

        JsonArray humanJson = dataObject.getAsJsonArray("humans");
        List<Human> carHumans = new ArrayList<>();
        for (JsonElement human: humanJson){
            carHumans.add(context.<Human>deserialize(human, Human.class));
        }
        car.setHumans(carHumans);
        return car;
    }
}
