// Класс лягушки, так называемый Receiver
public class Frog {
    // Этот класс будет иметь локальную переменную состояния,
    // представляющую величину прыжка лягушки
    // и константы возможных состояний лягушки
    public static final int MAX_POSITION = 10;
    public static final int MEDIUM_POSITION = 5;
    public static final int MIN_POSITION = 0;
    protected int position;

    public Frog() {
        position = MEDIUM_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    // метод прыжка лягушки
    public boolean jump(int steps) {
        // Это проверка величины прыжка, при прыжке влево steps будет вводиться со знаком "-"
        if ((position + steps > MAX_POSITION) || (position + steps < MIN_POSITION)) {
            return false;
        } else {
            position = position + steps;
            return true;

        }
    }

    // метод рисования нахождения лягушки
    public static void printField(int position) {

        for (int i = 0; i < 11; i++) {

            System.out.print("  " + i);
        }
        System.out.println();

        System.out.println("-----------------------------------");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 11; i++) {
            if (i == position) {

                stringBuilder.append("  X");
            } else
                stringBuilder.append("  O");

        }
        System.out.print(stringBuilder);

    }


}

