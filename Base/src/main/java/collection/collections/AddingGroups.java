package collection.collections;

import java.util.*;

/**
 * @author Halo
 * @create 2021/09/26 下午 05:48
 * @description 类添加
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        System.out.println("collection = " + collection);
        // Runs significantly faster, but you can't construct a Collection this way:
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        System.out.println("collection = " + collection);
        // Produces a list "backed by" an array:
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99); // OK -- modify an element
        System.out.println("list = " + list);
        // list.add(21); // Runtime error; the underlying array cannot be resized.
    }
}
