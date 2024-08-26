package homework_30.weekday;
//Задача 1. Задать ENUM weekDay - дни недели. Опробовать на нем методы:
// .VALUES() .toString .ordinal() .valueOf()
//Реализуйте метод, позволяющий прибавлять дни к выбранному дню недели, получая
// правильный день недели. Пример: Monday + 10 days = Thursday
// (понедельник + 10 дней = четверг) Проверьте работу метода с помощью теста.

public class WeekDayAppl {
    public static void main(String[] args) {

        WeekDay[] weekDays = WeekDay.values(); // все значения enum попали в массив

        System.out.println("------------------------------ values --------------------------");
        for (int i = 0; i < weekDays.length; i++) {
            System.out.println(weekDays[i].getNumber() + ": " + weekDays[i].getName());
        }

        // for each
        for (WeekDay wD : weekDays) {
            System.out.println(wD.getName());
        }
        System.out.println("--------------------------- toString --------------------------");
        String str = WeekDay.SUNDAY.toString();
        System.out.println(str);

        System.out.println("--------------------------- ordinal ---------------------------");
        int n = WeekDay.SUNDAY.ordinal();
        System.out.println(n);

        int m = WeekDay.WEDNESDAY.getNumber();
        System.out.println(m);

        System.out.println("--------------------------- valueOf ---------------------");
        WeekDay w = WeekDay.valueOf("MONDAY");
        System.out.println(w);
        System.out.println("--------------------------------------");

        WeekDay d = WeekDay.MONDAY;
        System.out.println(d);
        System.out.println(d.plusDay(d, 10));


    }
}
