package myPackage.j1basics;

class Car {

  private String description;

  public Car(String description) {
    this.description = description;
    System.out.println(this.description);
  }

  public void startEngine() {
    System.out.println("Car -> startEngine");
  }

  protected void runEngine() {
    System.out.println("Car -> runEngine");
  }

  public void drive() {
    System.out.println("Car -> driving, type is " + getClass().getSimpleName());
    runEngine();
  }
}

class GasPoweredCar extends Car {

  private double avgKmPerLiter;
  private int cylinders = 6;

  public GasPoweredCar(String description) {
    super(description);
  }

  public GasPoweredCar(String description, double avgKmPerLiter, int cylinders) {
    super(description);
    this.avgKmPerLiter = avgKmPerLiter;
    this.cylinders = cylinders;
  }

  @Override
  public void startEngine() {
    System.out.printf("Gas -> All %d cylinders are fired up, Ready!%n", cylinders);
  }

  @Override
  protected void runEngine() {
    System.out.printf("Gas -> usage exceeds the average: %.2f %n", avgKmPerLiter);
  }
}

public class OopsPolymorphism {

  public static void runRace(Car car) {
    car.startEngine();
    car.drive();
  }

  public static void main(String[] args) {
    Car car = new Car("2018 Maruti Alto 273 OTR");
    runRace(car);

    Car ferrari = new GasPoweredCar("2022 Blue Ferrari 296 GTS", 15.4, 6);
    runRace(ferrari);
  }
}
