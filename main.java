import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the starting x, y, z coordinates separated by spaces:");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the initial direction (N, S, E, W, U, D):");
        char direction = scanner.nextLine().charAt(0);

        Spacecraft chandrayaan3 = new Spacecraft(x, y, z, direction);

        System.out.println("Enter the commands (f, b, l, r, u, d) separated by spaces:");
        String commandLine = scanner.nextLine();
        char[] commands = commandLine.toCharArray();

        System.out.println("Starting Position: " + chandrayaan3.toString());

        for (char command : commands) {
            if (command == 'f' || command == 'b') {
                chandrayaan3.move(command);
            } else if (command == 'l' || command == 'r') {
                chandrayaan3.turn(command);
            } else if (command == 'u' || command == 'd') {
                chandrayaan3.tilt(command);
            }
            System.out.println("Command " + command + " - " + chandrayaan3.toString());
        }

        System.out.println("Final Position: " + chandrayaan3.toString());

        scanner.close();
    }
}

class Spacecraft {
    private int x;
    private int y;
    private int z;
    private char direction; // N, S, E, W, U, D

    public Spacecraft(int x, int y, int z, char direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
    }

    // Add getters for x, y, z, and direction if needed

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ") - " + direction;
    }

    public void move(char command) {
        switch (direction) {
            case 'N':
                if (command == 'f')
                    y++;
                else if (command == 'b')
                    y--;
                break;
            case 'S':
                if (command == 'f')
                    y--;
                else if (command == 'b')
                    y++;
                break;
            case 'E':
                if (command == 'f')
                    x++;
                else if (command == 'b')
                    x--;
                break;
            case 'W':
                if (command == 'f')
                    x--;
                else if (command == 'b')
                    x++;
                break;
            case 'U':
                if (command == 'f')
                    z--;
                else if (command == 'b')
                    z++;
                break;
            case 'D':
                if (command == 'f')
                    z++;
                else if (command == 'b')
                    z--;
                break;
        }
    }

    public void turn(char command) {
        switch (direction) {
            case 'N':
                direction = (command == 'l') ? 'W' : 'E';
                break;
            case 'S':
                direction = (command == 'l') ? 'E' : 'W';
                break;
            case 'E':
                direction = (command == 'l') ? 'N' : 'S';
                break;
            case 'W':
                direction = (command == 'l') ? 'S' : 'N';
                break;
            case 'U':
                direction = (command == 'l') ? 'N' : 'S';
                break;
            case 'D':
                direction = (command == 'l') ? 'S' : 'N';
                break;
        }
    }

    public void tilt(char command) {
        if (command == 'u') {
            if (direction == 'N' || direction == 'S')
                direction = 'U';
            else if (direction == 'U')
                direction = 'S';
            else if (direction == 'D')
                direction = 'N';
        } else if (command == 'd') {
            if (direction == 'N' || direction == 'S')
                direction = 'D';
            else if (direction == 'U')
                direction = 'N';
            else if (direction == 'D')
                direction = 'S';
        }
    }
}