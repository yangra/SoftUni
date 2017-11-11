package _09Nov2017.models.animals;

public abstract class Animal {
    private String name;
    private int age;
    private String adoptionCenter;
    private boolean cleansingStatus;
    private boolean adoptionStatus;
    private boolean castrationStatus;

    protected Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.cleansingStatus = false;
        this.adoptionStatus = false;
        this.castrationStatus = false;
    }

    protected void setAdoptionCenter(String adoptionCenter) {
        this.adoptionCenter = adoptionCenter;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAdopted() {
        return this.adoptionStatus;
    }

    public String getAdoptionCenter(){
        return this.adoptionCenter;
    }

    public void setAdopted(boolean adopted) {
        this.adoptionStatus = adopted;
    }

    public void setCleansingStatus(boolean cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }

    public boolean getCleansingStatus() {
        return this.cleansingStatus;
    }

    public boolean getCastrationStatus() {
        return this.castrationStatus;
    }

    public void setCastrationStatus(boolean castrated) {
        this.castrationStatus = castrated;
    }
}
