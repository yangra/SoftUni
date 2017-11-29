package _08PetClinics;

public interface Clinic {
    boolean add(Pet pet);
    boolean release();
    boolean hasEmptyRooms();
    String print();
    String print(int roomNumber);
}
