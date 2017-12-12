package _01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Class solidLand = RichSoilLand.class;
		Field[] fields = solidLand.getDeclaredFields();
		while(true){
			String line = reader.readLine();
			if("HARVEST".equalsIgnoreCase(line)){
				break;
			}
			for (Field field : fields) {
				if("all".equalsIgnoreCase(line)||Modifier.toString(field.getModifiers()).equalsIgnoreCase(line)){
					System.out.printf("%s %s %s\n", Modifier.toString(field.getModifiers()),
							field.getType().getSimpleName(), field.getName());
				}
			}
		}

	}
}
