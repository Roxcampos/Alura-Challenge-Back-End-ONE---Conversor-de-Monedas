import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FiltroMonedas {

    public static double obtenerTasa(String json, String codigoMoneda) {
        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        JsonObject conversiones = obj.getAsJsonObject("conversion_rates");
        return conversiones.get(codigoMoneda).getAsDouble();
    }
}
