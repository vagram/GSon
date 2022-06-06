package serializations;

import Entity.Car;
import Entity.Human;
import com.google.gson.*;

import java.lang.reflect.Type;

public class CarSerializator implements JsonSerializer<Car> {
    @Override
    public JsonElement serialize(Car car, Type type, JsonSerializationContext context) {
        JsonObject carObject = new JsonObject();
        carObject.add("engine", context.serialize(car.getEngine()));
        carObject.addProperty("CAR_brand", car.getBrand());
        carObject.addProperty("type", car.getType());

        JsonArray humanArray = new JsonArray();
        for (Human human: car.getHumans()){
            humanArray.add(context.serialize(human));
        }

        carObject.add("humans", humanArray);
        return carObject;

    }
}
