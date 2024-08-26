package homework_30.weekday;

// Задача 1. Задать ENUM weekDay - дни недели. Опробовать на нем методы:
// .VALUES() .toString .ordinal() .valueOf()
//Реализуйте метод, позволяющий прибавлять дни к выбранному дню недели,
// получая правильный день недели. Пример: Monday + 10 days = Thursday
// (понедельник + 10 дней = четверг) Проверьте работу метода с помощью теста.
public enum WeekDay {
    MONDAY("Monday", 1), TUESDAY("Tuesday", 2), WEDNESDAY("Wednesday", 3),
    THURSDAY("Thursday", 4), FRIDAY("Friday", 5), SATURDAY("Saturday", 6),
    SUNDAY("Sunday", 7);

    //fields
    private String name;
    private int number;

    WeekDay(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WeekDay{");
        sb.append("name='").append(name).append('\'');
        sb.append(", number=").append(number);
        sb.append('}');
        return sb.toString();
    }

    public WeekDay plusDay(WeekDay day, int quantity) {
        int index = day.ordinal(); // index of day
        index += quantity;
        WeekDay[] days = values();
        int res = index % days.length;
        return days[res];


    }
}
