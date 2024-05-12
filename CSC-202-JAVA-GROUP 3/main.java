import java.util.Scanner;

interface AreaCalculator {
    double calculateArea();
}

interface VolumeCalculator {
    double calculateVolume();
}

class Triangle implements AreaCalculator {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }
}

class Circle implements AreaCalculator {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements AreaCalculator {
    private final double length;
    private final double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double calculateArea() {
        return length * breadth;
    }
}

class Sphere implements AreaCalculator, VolumeCalculator {
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return 4 * Math.PI * radius * radius;
    }

    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}

class Cube implements AreaCalculator, VolumeCalculator {
    private final double length;

    public Cube(double length) {
        this.length = length;
    }

    public double calculateArea() {
        return 6 * length * length;
    }

    public double calculateVolume() {
        return length * length * length;
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a shape:");
        System.out.println("1. Triangle");
        System.out.println("2. Circle");
        System.out.println("3. Rectangle");
        System.out.println("4. Sphere");
        System.out.println("5. Cube");

        int choice = scanner.nextInt();

        AreaCalculator shape = null;

        switch (choice) {
            case 1:
                System.out.println("Enter the base:");
                double base = scanner.nextDouble();
                System.out.println("Enter the height:");
                double height = scanner.nextDouble();
                shape = new Triangle(base, height);
                break;
            case 2:
                System.out.println("Enter the radius:");
                double radius = scanner.nextDouble();
                shape = new Circle(radius);
                break;
            case 3:
                System.out.println("Enter the length:");
                double length = scanner.nextDouble();
                System.out.println("Enter the breadth:");
                double breadth = scanner.nextDouble();
                shape = new Rectangle(length, breadth);
                break;
            case 4:
                System.out.println("Enter the radius:");
                double sphereRadius = scanner.nextDouble();
                shape = new Sphere(sphereRadius);
                break;
            case 5:
                System.out.println("Enter the length:");
                double cubeLength = scanner.nextDouble();
                shape = new Cube(cubeLength);
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println("Area: " + shape.calculateArea());

        if (shape instanceof VolumeCalculator) {
            VolumeCalculator volumeCalculator = (VolumeCalculator) shape;
            System.out.println("Volume: " + volumeCalculator.calculateVolume());
        }
    }
}


// This code separates the concerns of area calculation and volume calculation using the strategy pattern, making it easier to extend and maintain in the future.