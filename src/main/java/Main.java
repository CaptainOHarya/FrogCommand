import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Класс Client - здесь будем вводить исходные данные и выводить информацию о
// действиях лягушки
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frog frog = new Frog();
        int step; // количество шагов лягушки;

        String input;// Переменная символа операции
        List<FrogCommand> commands = new ArrayList<>();
        // переменная состояния текущей команды
        int curCommand = -1;
        System.out.println("Вас приветствует игра 'Лягушка' ");
        System.out.println(" ");
        System.out.println("Поле нахождения лягушки ('текущее положение отмечено X') ");
        // Рисуем поле нынешнего положения лягушки
        frog.printField(frog.getPosition());
        System.out.println(" ");


        while (true) {
            System.out.println(" ");
            System.out.println("Вы можете выбрать одно из следующих действий: ");
            System.out.println("'+N' - Прыгни на N шагов направо ");
            System.out.println("'-N' - Прыгни на N шагов налево ");
            System.out.println("'<<' - Undo (отмени последнюю команду) ");
            System.out.println("'>>' - Redo (повтори отменённую команду) ");
            System.out.println("'!!' - повтори последюю команду) ");
            System.out.println("'0' - выход ");
            System.out.println(" ");

            // Считываем номер задачи из консоли
            input = scanner.nextLine();
            // Если пользователь ввёл 0, то выходим из цикла
            if (input.equals("0")) {
                System.err.println(" Программа завершает свою работу!!! ");
                break;

            } else {
                if (input.equals("<<")) {//пользователь решил отменить действие
                    if (curCommand < 0) {
                        System.err.println("Отменять нечего!!!");
                    } else {
                        commands.get(curCommand).undo();
                        curCommand--;
                    }
                } else if (input.equals(">>")) {// пользователь решил повторить отменённое действие
                    if (curCommand == commands.size() - 1) {
                        System.err.println("Нечего повторять");
                    } else {
                        commands.get(curCommand).execute();
                        curCommand++;
                    }
                } else if (input.equals("!!")) {// пользователь хочет повторить действие
                    if (curCommand < 0) {
                        System.err.println("Нечего повторять");
                    } else {
                        commands.get(curCommand).execute();
                        if (commands.get(curCommand).execute()) curCommand++;
                    }
                } else { // новое движение для лягушки
                    if (curCommand != commands.size() - 1) {
                        for (int i = curCommand + 1; i < commands.size(); i++)
                            commands.remove(i);
                    }
                    step = Integer.parseInt(input);
                    FrogCommand cmd = FrogCommands.jumpRightCommand(frog, step);
                    curCommand++;
                    commands.add(cmd);
                    cmd.execute();

                }
                System.out.println(" Поле нахождения лягушки ('текущее положение отмечено X') ");
                // Рисуем поле нынешнего положения лягушки
                frog.printField(frog.getPosition());
                System.out.println(" ");


            }


        }
        scanner.close();
    }
}
