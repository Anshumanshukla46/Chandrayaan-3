public class Spacecraft {
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
}
