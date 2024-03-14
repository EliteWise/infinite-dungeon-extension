package fr.elite.infinitedungeon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

    /**
     * Deserializes any parameter of the JSON file into any tpe of data.
     * @param filePath The path to the JSON file.
     * @return A list of InventoryItem objects.
     * @throws IOException If an I/O error occurs.
     * @throws JsonProcessingException If the JSON is not formatted correctly.
     */
    public static <T> T deserializeJsonFile(String filePath, TypeReference<T> typeReference) throws IOException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new IOException("Cannot find resource: " + filePath);
        }
        return objectMapper.readValue(inputStream, typeReference);
    }
}
