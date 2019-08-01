

import java.util.Objects;
import java.util.Scanner;

public class LetsShipTheGoods {
    public static void main(String[] args) {
        int box = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите кол-во ящиков: ");
            box = scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cargo cargo = new Cargo(box);
        System.out.println(cargo);
        cargo.fullPrint();
    }
}

class Cargo {
    private int truck;
    private int container;
    private int box;

    public Cargo(int box) {
        this.box = box;
        if (box != 0) {
            container = box % 27 == 0 ? box / 27 : box / 27 + 1;
        }
        if (container != 0) {
            truck = container % 12 == 0 ? container / 12 : container / 12 + 1;
        }
    }


    public void fullPrint() {
        int b = 1;
        int c = 1;
        for (int i = 1; i <= truck; i++) {
            System.out.printf("Грузовик %d:\n", i);
            int j = 0;
            while (j < 12 && c <= container) {
                System.out.printf("Контейнер %3d: ", c);
                int k = 0;
                while (k < 27 && b <= box) {
                    System.out.printf("Ящик %3d ", b);
                    k++;
                    b++;
                }
                j++;
                c++;
                System.out.println();
            }
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return truck == cargo.truck &&
                container == cargo.container &&
                box == cargo.box;
    }

    public int hashCode() {
        return Objects.hash(truck, container, box);
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("Груз{");
        sb.append("грузовиков=").append(truck);
        sb.append(", контейнеров=").append(container);
        sb.append(", ящиков=").append(box);
        sb.append('}');
        return sb.toString();
    }
}