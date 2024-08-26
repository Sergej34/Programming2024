package homework_30.to_do_list;
// Task 2. Start implementing the "To-do list" application.
//Use enum to organize the menu (item number, action) of the application:
//add a task
//view all tasks
//delete a task (by number)
//exit the menu
//Implement the printMenu() method.
//Implement an application in which a user poll works, accepts his choice
// from the menu and reports what he has chosen.
//Задача 2. Начать реализацию приложения "Список дел".
//Использовать enum для организации меню (номер пункта, действие) приложения:
//добавить задачу
//посмотреть все задачи
//удалить задачу (по номеру)
//выйти из меню
//Реализовать метод printMenu().
//Реализовать приложение, в котором работает опрос пользователя,
// принимается его выбор из меню и сообщается, что он выбрал.
public enum MenuOption {
    ADD_TASK(1, "Add task"),
    VIEW_TASKS(2, "View all tasks"),
    DELETE_TASK(3, "Delete task"),
    EXIT(4, "Exit");

    private final int number;
    private final String description;

    MenuOption(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public static MenuOption fromNumber(int number) {
        for (MenuOption option : MenuOption.values()) {
            if (option.getNumber() == number) {
                return option;
            }
        }
        return null;  // Возвращаем null, если номер не найден
    }
}
