package softuni.io;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import softuni.exceptions.SerializeException;

import java.io.IOException;

@Component
public class JsonParser {
    private Gson gson;

    private final FileParser fileParser;

    @Autowired
    public JsonParser(FileParser fileParser) {
        this.fileParser = fileParser;
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
    }

    public <T> T deserialize(Class<T> clazz, String path){

        try {
            String json = this.fileParser.readFile(path);
            return this.gson.fromJson(json,clazz);
        } catch (IOException e) {
            //log here
            throw new SerializeException("Could not deserialize"+path, e);
        }


    }

    public <T> void serialize(T object, String path){
        String content = this.gson.toJson(object);
        try {
            this.fileParser.writeFile(path, content);
        } catch (IOException e) {
            //log here
            throw new SerializeException("Was not able to serialize" + object, e);
        }
    }
}
