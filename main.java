public class main {

    public static void main(String[] args) {
        System.out.println("Hello World");
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
}