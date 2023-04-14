package myPackage.j1basics;

abstract class Shape{
    private final int dim1;
    private final int dim2;

    public Shape(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    public int getDim1() {
        return dim1;
    }
    public int getDim2() {
        return dim2;
    }

    abstract public void areaOfShape();
    abstract public void perimeterOfShape();
}

class Square extends Shape{
    public Square(int dim) {
        super(dim, -1);
    }
    @Override
    public void areaOfShape(){
        int area = this.getDim1() * this.getDim1();
        System.out.println(area);
    }
    @Override
    public void perimeterOfShape(){
        int perimeter = 2 * (this.getDim1() + this.getDim1());
        System.out.println(perimeter);
    }
}

class Rectangle extends Shape{
    public Rectangle(int dim1, int dim2) {
        super(dim1, dim2);
    }
    @Override
    public void areaOfShape(){
        int area = this.getDim1() * this.getDim2();
        System.out.println(area);
    }
    @Override
    public void perimeterOfShape(){
        int perimeter = 2 * (this.getDim1() + this.getDim2());
        System.out.println(perimeter);
    }
}

class Circle extends Shape{
    public Circle(int dim1) {
        super(dim1, -1);
    }
    @Override
    public void areaOfShape(){
        double area = Math.PI*this.getDim1() * this.getDim1();
        System.out.println(area);
    }
    @Override
    public void perimeterOfShape(){
        double perimeter = 2 * Math.PI * this.getDim1();
        System.out.println(perimeter);
    }
}

interface Bicycle{
    void applyBrakes(int decrement);
    void speedUp(int increment);
    private void startBicycle(){
        System.out.println("Starting Bicycle at Gear " + 1);
    }
    default void changeGear(int finalGear){
        this.startBicycle();
        System.out.println("Changing Gear to " + finalGear);
    }
}

interface Lights{
    void frontLight();
    void backLight();
}

interface Horns{
    void hindiSong();
    void englishSong();
}

record MyCycle(int speed) implements Bicycle, Lights, Horns {

    public void applyBrakes(int decrement) {
        System.out.println(this.speed() - decrement);
    }
    public void speedUp(int increment) {
        System.out.println(this.speed() + increment);
    }
    public void frontLight() {
        System.out.println("Turning Front Light On...");
    }
    public void backLight() {
        System.out.println("Turning Back Light On...");
    }
    public void hindiSong(){
        System.out.println("Blowing Hindi Song Horn...");
    }
    public void englishSong(){
        System.out.println("Blowing English Song Horn...");
    }
}

public class AbstractInterface {
    public static void main(String[] args) {
        /*Square S = new Square(5);
        S.areaOfShape();
        S.perimeterOfShape();

        System.out.println();

        Rectangle R = new Rectangle(5,6);
        R.areaOfShape();
        R.perimeterOfShape();

        System.out.println();

        Circle C = new Circle(5);
        C.areaOfShape();
        C.perimeterOfShape();*/

//        Run Time Polymorphism (using Interfaces)
        /*Bicycle MCB = new MyCycle(5); // Only functions of Bicycle will be allowed in MCB object
        Lights MCL = new MyCycle(5); // Only functions of Lights will be allowed in MCB object
        Horns MCH = new MyCycle(5); // Only functions of Horns will be allowed in MCB object
        MCB.applyBrakes(2);
        MCB.speedUp(3);
        MCL.frontLight();
        MCH.hindiSong();
        MCL.backLight();
        MCH.englishSong();
        MCB.changeGear(3);*/

        System.out.println("Hello!");
    }
}
