package P06;

public class RobotImpl implements Robot,Identifiable{


    private String model;
    private String id;

    public RobotImpl(String model, String id){
        this.setModel(model);
        this.setId(id);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setId(String id) {
        this.id = id;
    }
}
