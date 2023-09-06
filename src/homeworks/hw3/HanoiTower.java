package homeworks.hw3;

public class HanoiTower {
    public static void main(String[] args) {
        int disk = 3;
        String left = "Лево";
        String right = "Право";
        String middle = "Центр";

        moveDisks(disk, left, right, middle);

    }

    public static void moveDisks(int disk, String left, String right, String middle) {
        if (disk == 1) {
            // Базовый случай: переместить один диск с исходного стержня на целевой
            System.out.println("Переместите диск 1 с " + left + " на " + right);
            return;
        }

        moveDisks(disk - 1, left, middle, right);

        System.out.println("Переместите диск " + disk + " с " + left + " на " + right);

        moveDisks(disk - 1, middle, right, left);
    }
}

