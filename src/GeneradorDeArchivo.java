import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public static void guardarJson(String nombreArchivo, String json) {
        try (FileWriter file = new FileWriter(nombreArchivo)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser parser = new JsonParser();
            JsonObject obj = parser.parse(json).getAsJsonObject();
            String prettyJsonString = gson.toJson(obj);
            file.write(prettyJsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
