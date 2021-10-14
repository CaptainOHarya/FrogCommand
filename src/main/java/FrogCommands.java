public class FrogCommands {

    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        return new FrogCommand() {

            @Override
            public boolean execute() {
                return frog.jump(steps);
            }

            @Override
            public boolean undo() {
                return frog.jump(-steps);
            }
        };
    }


}

