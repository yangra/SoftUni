package _08PetClinics;


import java.util.Arrays;
import java.util.Iterator;

public class ClinicImpl implements Iterable<Room>, Clinic {
    private String name;
    private Room[] rooms;

    public ClinicImpl(String name, int numberOfRooms) {
        validateNumberOfRooms(numberOfRooms);
        this.name = name;
        this.rooms = new Room[numberOfRooms];
        for (int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new Room();
        }
    }

    private void validateNumberOfRooms(int numberOfRooms) {
        if (numberOfRooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
    }

    @Override
    public boolean add(Pet pet) {
        if (!this.hasEmptyRooms()) {
            return false;
        }

        for (Room room : this.addIterate()) {
            if (room.isEmpty()) {
                room.addPet(pet);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean release() {
        for (Room room : this.releaseIterate()) {
            if (!room.isEmpty()) {
                room.releasePet();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasEmptyRooms() {
        return Arrays.stream(this.rooms).filter(Room::isEmpty).count() > 0;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Room room : this.rooms) {
            sb.append(room.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String print(int roomNumber) {
        Room room = this.rooms[roomNumber - 1];
        return room.toString();
    }

    private Iterable<Room> addIterate() {

        return new Iterable<Room>() {
            @Override
            public Iterator<Room> iterator() {
                return new RoomAddIterator();
            }
        };
    }

    private Iterable<Room> releaseIterate() {

        return new Iterable<Room>() {
            @Override
            public Iterator<Room> iterator() {
                return new RoomReleaseIterator();
            }
        };
    }

    @Override
    public Iterator<Room> iterator() {
        return new RoomIterator();
    }

    private final class RoomIterator implements Iterator<Room> {

        private int index;

        public RoomIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < rooms.length;
        }

        @Override
        public Room next() {
            return rooms[this.index++];
        }
    }

    private final class RoomAddIterator implements Iterator<Room> {

        private int index;

        public RoomAddIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < rooms.length;
        }

        @Override
        public Room next() {
            if (this.index == 0) {
                Room room = rooms[rooms.length / 2];
                this.index++;
                return room;
            }

            if (this.index % 2 == 0) {
                Room room = rooms[rooms.length / 2 + this.index / 2];
                this.index++;
                return room;
            } else {
                Room room = rooms[rooms.length / 2 - this.index / 2 - 1];
                this.index++;
                return room;
            }
        }
    }

    private final class RoomReleaseIterator implements Iterator<Room> {

        private int index;

        public RoomReleaseIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < rooms.length;
        }

        @Override
        public Room next() {
            if (this.index <= rooms.length / 2) {
                Room room = rooms[rooms.length / 2 + this.index];
                this.index++;
                return room;
            } else {
                Room room = rooms[this.index - rooms.length / 2 - 1];
                this.index++;
                return room;
            }
        }
    }
}
