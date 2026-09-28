import structure.FixedCapacityStackOfStrings;
import util.Reader;

import java.io.IOException;

public class Entry {
    public static void main(String[] args) throws IOException {
        final int SIZE = 100;
        FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(SIZE);
        Reader reader = new Reader();
        String[] strings = reader.ReadFromFile("src/main/resources/1.3.2.txt");
//        for (String s : strings) {
//            System.out.println(s);
//        }
//        System.out.println();
        for (String s : strings) {
            if (s.compareTo("-") != 0)  {
                fixedCapacityStackOfStrings.push(s);
            } else if (!fixedCapacityStackOfStrings.isEmpty()) {
                System.out.print(fixedCapacityStackOfStrings.pop() + " ");
            }
        }
        System.out.println();
        System.out.println(fixedCapacityStackOfStrings.size());

    }
}
