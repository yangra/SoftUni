package softuni.io;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
                .create();
    }

    public <T> T deserialize(Class<T> clazz, String path){
        T obj = null;
        String json = this.fileParser.readFile(path);
        obj = this.gson.fromJson(json,clazz);
        return obj;
    }

    public <T> void serialize(T object, String path){
        String content = this.gson.toJson(object);
        this.fileParser.writeFile(path, content);
    }
}
