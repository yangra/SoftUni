package _08PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        int numberOfCommands = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] input = reader.readLine().split("\\s+");
            switch (input[0]){
                case "Create":
                    switch (input[1]){
                        case "Pet":
                            Pet pet = new Pet(input[2], Integer.parseInt(input[3]), input[4]);
                            pets.put(input[2], pet);
                            break;
                        case "Clinic":
                            try{
                                Clinic clinic = new ClinicImpl(input[2], Integer.parseInt(input[3]));
                                clinics.put(input[2], clinic);
                            }catch (IllegalArgumentException iae){
                                System.out.println(iae.getMessage());
                            }
                            break;
                    }
                    break;
                case "Add":
                    Pet pet = pets.get(input[1]);
                    Clinic clinic = clinics.get(input[2]);
                    System.out.println(clinic.add(pet));
                    break;
                case "Release":
                    clinic = clinics.get(input[1]);
                    System.out.println(clinic.release());
                    break;
                case "HasEmptyRooms":
                    clinic = clinics.get(input[1]);
                    System.out.println(clinic.hasEmptyRooms());
                    break;
                case "Print":
                    clinic = clinics.get(input[1]);
                    if(input.length == 3){
                        System.out.println(clinic.print(Integer.parseInt(input[2])));
                    }else{
                        System.out.println(clinic.print());
                    }
                    break;
            }
        }
    }
}
