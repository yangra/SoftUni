package softuni.io;


import org.springframework.stereotype.Component;
import softuni.exceptions.SerializeException;

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

    public XmlParser() {
    }

    public <T> T deserialize(Class<T> clazz, String path){
        try {
            this.jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
            T object = null;
            try (
                    InputStream inputStream = this.getClass().getResourceAsStream(path);
            ) {
                object = (T) unmarshaller.unmarshal(inputStream);
            }
            return object;
        } catch (IOException e) {
            throw new SerializeException("Could not deserialize", e);
        } catch (JAXBException je) {
            throw new SerializeException("Could not deserialize", je);
        }
    }

    public <T> void serialize(T object, String path){
        try {
            this.jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = this.jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            try (OutputStream outputStream = new FileOutputStream(path);) {
                marshaller.marshal(object, outputStream);
            }
        } catch (IOException e) {
            throw new SerializeException("Could not serialize" + object, e);
        } catch (JAXBException je) {
            throw new SerializeException("Could not serialize" + object, je);
        }
    }
}
