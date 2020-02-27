package lesson5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Employee[] empArr = new Employee[5];
        empArr[0] = new Employee("Жиров Даниил Леонтиевич", "Мясник", "gdl@mail.ru", "+79052569235", 12000, 63);
        empArr[1] = new Employee("Лобза Марина Феликсовна", "Летчик", "lmf@mail.ru", "+79524218799", 65000, 55);
        empArr[2] = new Employee("Погребнов Станислав Трофимович", "Бортинженер", "pst@mail.ru", "+79863211232", 50000, 47);
        empArr[3] = new Employee("Изотов Бронислав Святославович", "Менеджер по закупкам", "ibs@mail.ru", "+79036589514", 20000, 24);
        empArr[4] = new Employee("Миков Потап Сидорович", "Шахтер", "mps@mail.ru", "+79121478523", 60000, 40);

        for (int i = 0; i < empArr.length; i++) {
            if (empArr[i].getAge() >= 40) {
                empArr[i].printInfo();
            }
        }
    }
}






