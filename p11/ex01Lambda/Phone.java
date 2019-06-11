package p11.ex01Lambda;

public class Phone {
    private double price;
    private int memory;
    private String brand;
    private int camera;

    public Phone(double price, int mem, String brand, int camera) {
        this.price = price;
        this.memory = mem;
        this.brand = brand;
        this.camera = camera;
    }

    public double getPrice() {
        return this.price;
    }

    public int getMemory() {
        return this.memory;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getCamera() {
        return this.camera;
    }

    @Override
    public String toString() {
        return "Phone {" + "price: " + price + ", memory: " + memory + ", brand: " + brand + ", camera: " + camera
                + '}';
    }

}