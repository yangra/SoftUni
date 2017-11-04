package _01ClassBox;

class Box {
    private double length;
    private double width;
    private double height;


    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    double getVolume(){
       return length*width*height;
    }

    double getLateralSurfaceArea(){
        return 2*length*height + 2*width*height;
    }
    double getSurfaceArea(){
        return 2*length*width + 2*length*height + 2*width*height;
    }
}
