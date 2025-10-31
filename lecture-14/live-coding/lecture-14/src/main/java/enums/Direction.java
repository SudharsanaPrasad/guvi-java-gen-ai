package enums;

enum Directions {
    EAST, WEST, NORTH, SOUTH, NORTH_EAST
}

public class Direction {
    public static void main(String[] args) {
//        System.out.println(Directions.EAST.toString());
//        System.out.println(Directions.WEST.toString());
//        System.out.println(Directions.NORTH_EAST.toString());

        // direction object
//        if(direction == Directions.EAST) {
//            // logic
//        }
        for(Directions dir : Directions.values()) {
            System.out.println(dir);
        }
    }
}
