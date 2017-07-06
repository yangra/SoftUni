package P06;


class Product {


    private String name;
    private double cost;

    Product(String name, double cost) throws IllegalStateException{
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) throws  IllegalStateException{
        if(name.isEmpty()||name.trim().equals("")){
            System.out.println("Name cannot be empty");
            throw new IllegalStateException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setCost(double cost) throws IllegalStateException {
        if (cost < 0){
            System.out.println("Money cannot be negative");
            throw new IllegalStateException("Money cannot be negative");
        }
        this.cost = cost;
    }

    double getCost() {
        return cost;
    }

    String getName() {
        return name;
    }
}
