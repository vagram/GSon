package serializations;

import Entity.Engine;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class EngineSerializator implements JsonSerializer<Engine> {

    @Override
    public JsonElement serialize(Engine engine, Type type, JsonSerializationContext context) {
        JsonObject engineObject = new JsonObject();
        engineObject.addProperty("name", engine.getName());
        engineObject.addProperty("ENGINE brand",engine.getBrand());
        engineObject.addProperty("volume",engine.getVolume());


        return engineObject;
    }
}
