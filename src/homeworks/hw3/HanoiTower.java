package homeworks.hw3;

public class HanoiTower {
    public static void main(String[] args) {
        int disk = 3;
        String left = "Лево"; // Исходный стержень
        String right = "Право"; // Целевой стержень
        String middle = "Центр"; // Вспомогательный стержень

        moveDisks(disk, left, right, middle);

    }

    public static void moveDisks(int disk, String left, String right, String middle) {
        if (disk == 1) {
            // Базовый случай: переместить один диск с исходного стержня на целевой
            System.out.println("Переместите диск 1 с " + left + " на " + right);
            return;
        }

        // Рекурсивно перемещаем (n-1) дисков с исходного стержня на вспомогательный
        moveDisks(disk - 1, left, middle, right);

        // Перемещаем оставшийся диск с исходного стержня на целевой
        System.out.println("Переместите диск " + disk + " с " + left + " на " + right);

        // Рекурсивно перемещаем (n-1) дисков с вспомогательного стержня на целевой
        moveDisks(disk - 1, middle, right, left);
    }
}

