import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shape = scanner.nextLine();
        double shapeSquare = 0.0;
        double a, b, c, p, r;
        switch (shape) {
            case "triangle" -> {
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                c = scanner.nextDouble();
                p = (a + b + c) / 2;
                shapeSquare = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            }
            case "rectangle" -> {
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                shapeSquare = a * b;
            }
            case "circle" -> {
                r = scanner.nextDouble();
                shapeSquare = 3.14 * r * r;
            }
        }
        System.out.println(shapeSquare);
    }
}
