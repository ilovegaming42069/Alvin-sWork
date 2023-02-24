abstract class Shape {
    String color;
    abstract int getArea();
    public Shape(String color){
        this.color = color;
    }

}

class Rectangle extends Shape {
    int width;
    int height;
    public Rectangle(int width, int height, String color){
        super(color);
        this.width = width;
        this.height = height;
    }
    @Override
    public int getArea(){
        return this.height*this.width;
    }
}

class Gay {
    public static void main(String[] args){
        Rectangle constructor = new Rectangle(60, 60, "Gay");
        System.out.print(constructor.getArea());
    }
}




