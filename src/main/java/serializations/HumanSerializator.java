package serializations;

import Entity.Human;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class HumanSerializator implements JsonSerializer<Human> {
    @Override
    public JsonElement serialize(Human human, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(human.getName() + " " + human.getAge());
    }
}
