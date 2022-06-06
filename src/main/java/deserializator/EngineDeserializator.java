package deserializator;

import Entity.Engine;
import com.google.gson.*;

import java.lang.reflect.Type;

public class EngineDeserializator implements JsonDeserializer<Engine> {
    @Override
    public Engine deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        Engine engine = new Engine();
        JsonObject dataObject = jsonElement.getAsJsonObject();
        engine.setName(dataObject.get("name").getAsString());
        engine.setBrand(dataObject.get("ENGINE brand").getAsString());
        engine.setVolume(dataObject.get("volume").getAsDouble());
        engine.setBrandEngine("При сериализации значение не показывается!");
        return engine;

    }
}
