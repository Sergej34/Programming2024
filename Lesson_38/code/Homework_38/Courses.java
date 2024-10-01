package Homework_38;

import java.util.HashSet;
import java.util.Set;

public class Courses {

    // Задача 2. Напишите программу, которая: Создает список студентов, зарегистрированных на два разных курса:
    // "Математика" и "Информатика". Выводит: Список студентов, которые записаны на оба курса.
    // Список студентов, которые записаны только на один из курсов.
    // Условия: Используйте два HashSet для хранения студентов каждого курса.
    // Программа должна использовать операции пересечения и разности множеств для вывода нужных списков.

    public static void main(String[] args) {

        // 1. Создадим список студентов для каждого курса
        Set<String> mathStudents = new HashSet<>();
        Set<String> infStudents = new HashSet<>();

        // Добавление студентов на курс "Математика"
        mathStudents.add("Иванов");
        mathStudents.add("Петров");
        mathStudents.add("Сидоров");
        mathStudents.add("Смирнов");

        // Добавление студентов на курс "Информатика"
        infStudents.add("Петров");
        infStudents.add("Сидоров");
        infStudents.add("Кузнецов");
        infStudents.add("Алексеев");

        // 2. Список студентов, записанных на оба курса
        Set<String> bothCourses = new HashSet<>(mathStudents);
        bothCourses.retainAll(infStudents); // Пересечение множеств

        // 3. Список студентов, записанных только на один из курсов
        Set<String> onlyOneCourse = new HashSet<>(mathStudents);
        onlyOneCourse.addAll(infStudents);  // Объединяем оба множества

        Set<String> both = new HashSet<>(bothCourses);
        onlyOneCourse.removeAll(both);      // Убираем студентов, записанных на оба курса

        // Вывод результатов
        System.out.println("Студенты, записанные на оба курса: " + bothCourses);
        System.out.println("Студенты, записанные только на один из курсов: " + onlyOneCourse);

    } // end of main
}
