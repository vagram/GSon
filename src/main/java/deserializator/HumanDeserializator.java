package deserializator;

import Entity.Human;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class HumanDeserializator implements JsonDeserializer<Human> {
    @Override
    public Human deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        Human human = new Human();
        String data = jsonElement.getAsString();
        String[] element = data.split("\\s+",2);
        human.setAge(Integer.parseInt(element[1]));
        human.setName(element[0]);
        return human;
    }
}
