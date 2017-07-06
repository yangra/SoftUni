package P05;

public class RobotImpl implements Identifiable, Robot{


    private String model;
    private String id;

    RobotImpl(String model, String id){
        this.setModel(model);
        this.setId(id);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getModel() {
        return null;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setId(String id) {
        this.id = id;
    }
}
