package homework_30.to_do_list;
import java.util.Scanner;

public class ToDoAppl {

    private static final Scanner scanner = new Scanner(System.in);
    private static String[] tasks = new String[10];
    private static int taskCount = 0;

    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            MenuOption option = MenuOption.fromNumber(choice);

            if (option == null) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            switch (option) {
                case ADD_TASK:
                    addTask();
                    break;
                case VIEW_TASKS:
                    viewTasks();
                    break;
                case DELETE_TASK:
                    deleteTask();
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

    private static void addTask() {
        if (taskCount >= tasks.length) {
            System.out.println("Task list is full. Cannot add more tasks.");
            return;
        }

        System.out.print("Enter the task description: ");
        String task = scanner.nextLine();
        tasks[taskCount] = task;
        taskCount++;
        System.out.println("Task added.");
    }

    private static void viewTasks() {
        if (taskCount == 0) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + ". " + tasks[i]);
            }
        }
    }

    private static void deleteTask() {
        viewTasks();
        if (taskCount > 0) {
            System.out.print("Enter the task number to delete: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine();  // consume newline

            if (taskNumber < 1 || taskNumber > taskCount) {
                System.out.println("Invalid task number.");
            } else {
                for (int i = taskNumber - 1; i < taskCount - 1; i++) {
                    tasks[i] = tasks[i + 1];
                }
                tasks[taskCount - 1] = null;  // Clear the last task
                taskCount--;
                System.out.println("Task deleted.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("To-Do List Menu:");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getNumber() + ". " + option.getDescription());
        }
    }
}
