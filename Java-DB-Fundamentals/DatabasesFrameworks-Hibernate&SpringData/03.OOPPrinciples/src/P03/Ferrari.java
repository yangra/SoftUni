package P03;

public class Ferrari implements Car, Driver {
    private final String model;
    private String name;

    Ferrari(String driver){
        this.setName(driver);
        this.model = "488-Spider";
    }

    @Override
    public void brakes() {
        System.out.print("Brakes!");
    }

    @Override
    public void gas() {
        System.out.print("Zadu6avam sA!");
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
