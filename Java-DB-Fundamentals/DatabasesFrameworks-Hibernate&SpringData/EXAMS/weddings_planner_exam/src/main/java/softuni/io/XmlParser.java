package softuni.io;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Component
public class XmlParser {
    private JAXBContext jaxbContext;

    public XmlParser(){
    }

    public <T> T deserialize(Class<T> clazz, String path) throws JAXBException, IOException {
        this.jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
        T object = null;
        try(
                InputStream inputStream = this.getClass().getResourceAsStream(path);
        ){
            object = (T)unmarshaller.unmarshal(inputStream);
        }
        return object;
    }

    public <T> void  serialize(T object, String path) throws JAXBException, IOException {
        this.jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = this.jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        try(
                OutputStream outputStream = new FileOutputStream(path);
        ){
            marshaller.marshal(object,outputStream);
        }
    }
}
