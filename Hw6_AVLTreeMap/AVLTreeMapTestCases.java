/**
 * @author Brian S. Borowski
 * Test cases for Programming Assignment 5 - BST Map
 * COMS W3134
 * Date created: 10/19/2022
 * Last modified: 10/25/2022
 */


import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AVLTreeMapTestCases {

    public static final double DELTA = 1e-7;

    private Method getTraversal(AVLTreeMap map, String traversal) throws NoSuchMethodException {
        Method method = map.getClass().getSuperclass().getDeclaredMethod(traversal, Node.class, StringBuilder.class, int.class);
        method.setAccessible(true);
        return method;
    }

    private Method getIterativeSearchMethod(AVLTreeMap map) throws NoSuchMethodException {
        Method method = map.getClass().getSuperclass().getDeclaredMethod("iterativeSearch", Comparable.class);
        method.setAccessible(true);
        return method;
    }

    @Test
    public void testPut01() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        AVLTreeMap<Integer, Integer> map = new AVLTreeMap<>();
        assertEquals("[]", map.inorder());
        assertEquals(0, map.size());
        assertEquals(true, map.isEmpty());
        Integer retVal = map.put(10, 10);
        assertEquals(null, retVal);
        assertEquals("[<10, 10>]", map.inorder());
        assertEquals(1, map.size());
        assertEquals(false, map.isEmpty());
        assertEquals(null, ((Node<Integer, Integer>)getIterativeSearchMethod(map).invoke(map, 10)).parent);
        retVal = map.put(2, 2);
        assertEquals(null, retVal);
        assertEquals(10, ((Node<Integer, Integer>)getIterativeSearchMethod(map).invoke(map, 2)).parent.key);
        retVal = map.put(2, 3);
        assertEquals(2, retVal);
        assertEquals(10, ((Node<Integer, Integer>)getIterativeSearchMethod(map).invoke(map, 2)).parent.key);
        retVal = map.put(5, 2);
        assertEquals(null, retVal);
        assertEquals(null, ((Node<Integer, Integer>)getIterativeSearchMethod(map).invoke(map, 5)).parent);



        retVal=map.put(16, 17);

        retVal=map.put(11, 15);
        retVal=map.put(14, 13);


        retVal=map.put(1, 4);

        retVal=map.put(24, 25);

        retVal=map.put(26, 27);

        retVal = map.put(12, 13);

        retVal = map.put(35, 36);
        retVal = map.put(8, 9);
        retVal = map.put(5, 18);
        retVal = map.put(4, 7);


        System.out.println(map.toAsciiDrawing());
    }
    @Test
    public void testPut02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        AVLTreeMap<Integer, Integer> map = new AVLTreeMap<>();
        assertEquals("[]", map.inorder());
        assertEquals(0, map.size());
        assertEquals(true, map.isEmpty());
        System.out.println(map.size());

        Integer retVal = map.put(50, 10);
        System.out.println("post");
        assertEquals(null, retVal);
        assertEquals("[<50, 10>]", map.inorder());
        assertEquals(1, map.size());
        assertEquals(false, map.isEmpty());
        assertEquals(null, ((Node<Integer, Integer>) getIterativeSearchMethod(map).invoke(map, 50)).parent);
        System.out.println("map:" + map.toAsciiDrawing());

        retVal = map.put(75, 2);
        System.out.println("post2");
        assertEquals(null, retVal);
        assertEquals(50, ((Node<Integer, Integer>) getIterativeSearchMethod(map).invoke(map, 75)).parent.key);
        System.out.println("map:" + map.toAsciiDrawing());
        assertEquals(2, map.size());

        System.out.println("what");
        retVal = map.put(75, 3);
        System.out.println("post3");
        assertEquals(2, retVal);
        assertEquals(50, ((Node<Integer, Integer>) getIterativeSearchMethod(map).invoke(map, 75)).parent.key);
        System.out.println("map:" + map.toAsciiDrawing());
        assertEquals(2, map.size());


        retVal = map.put(100, 2);
        assertEquals(null, retVal);
        assertEquals(75, ((Node<Integer, Integer>) getIterativeSearchMethod(map).invoke(map, 100)).parent.key);
        assertEquals(75, ((Node<Integer, Integer>) getIterativeSearchMethod(map).invoke(map, 50)).parent.key);
        System.out.println("map:" + map.toAsciiDrawing());
        assertEquals(3, map.size());


        retVal = map.put(80, 5);
        assertEquals(null, retVal);
        assertEquals(100, ((Node<Integer, Integer>) getIterativeSearchMethod(map).invoke(map, 80)).parent.key);
        System.out.println("map:" + map.toAsciiDrawing());
        assertEquals(4, map.size());


        retVal = map.put(80, 10);
        assertEquals(5, retVal);
        assertEquals(100, ((Node<Integer, Integer>) getIterativeSearchMethod(map).invoke(map, 80)).parent.key);
        System.out.println("map:" + map.toAsciiDrawing());
        assertEquals(4, map.size());


        retVal = map.put(85, 20);
        assertEquals(null, retVal);
        assertEquals(null, ((Node<Integer, Integer>) getIterativeSearchMethod(map).invoke(map, 75)).parent);
        assertEquals(75, ((Node<Integer, Integer>) getIterativeSearchMethod(map).invoke(map, 50)).parent.key);
        assertEquals(75, ((Node<Integer, Integer>) getIterativeSearchMethod(map).invoke(map, 85)).parent.key);
        assertEquals(85, ((Node<Integer, Integer>) getIterativeSearchMethod(map).invoke(map, 80)).parent.key);
        assertEquals(85, ((Node<Integer, Integer>) getIterativeSearchMethod(map).invoke(map, 100)).parent.key);
        System.out.println("map:" + map.toAsciiDrawing());
        assertEquals(5, map.size());

    }




    @Test
    public void testGet01() {
        Pair<Integer, Integer>[] pairs = new Pair[0];
        pairs = new Pair[10];
        for (int i = 0; i < 10; i++) {
            pairs[i] = new Pair(i, i+1);
        }
        AVLTreeMap<Integer, Integer> map = new AVLTreeMap<>(pairs, true);
        for (int i = 0; i < 10; i++) {
            assertEquals(i + 1, map.get(i));
        }
        assertEquals(null, map.get(10));
        assertEquals(null, map.get(-1));
    }

    @Test
    public void testRemove01() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Pair<Integer, Integer>[] pairs = new Pair[0];
        pairs = new Pair[10];
        for (int i = 0; i < 10; i++) {
            pairs[i] = new Pair(i, i+1);
        }
        AVLTreeMap<Integer, Integer> map = new AVLTreeMap<>(pairs, true);

        Integer retVal = map.remove(4);
        assertEquals(5, retVal);
        assertEquals("[<5, 6>, <1, 2>, <0, 1>, <2, 3>, <3, 4>, <7, 8>, <6, 7>, <8, 9>, <9, 10>]", map.preorder());
        assertEquals("[<0, 1>, <1, 2>, <2, 3>, <3, 4>, <5, 6>, <6, 7>, <7, 8>, <8, 9>, <9, 10>]", map.inorder());
        assertEquals(9, map.size());
        assertEquals(false, map.isEmpty());
        assertEquals(5, ((Node<Integer, Integer>)getIterativeSearchMethod(map).invoke(map, 1)).parent.key);

        retVal = map.remove(0);
        assertEquals(1, retVal);
        assertEquals("[<5, 6>, <2, 3>, <1, 2>, <3, 4>, <7, 8>, <6, 7>, <8, 9>, <9, 10>]", map.preorder());
        assertEquals("[<1, 2>, <2, 3>, <3, 4>, <5, 6>, <6, 7>, <7, 8>, <8, 9>, <9, 10>]", map.inorder());
        assertEquals(8, map.size());
        assertEquals(false, map.isEmpty());
        assertEquals(2, ((Node<Integer, Integer>)getIterativeSearchMethod(map).invoke(map, 1)).parent.key);

        retVal = map.remove(5);
        assertEquals(6, retVal);
        assertEquals("[<6, 7>, <2, 3>, <1, 2>, <3, 4>, <8, 9>, <7, 8>, <9, 10>]", map.preorder());
        assertEquals("[<1, 2>, <2, 3>, <3, 4>, <6, 7>, <7, 8>, <8, 9>, <9, 10>]", map.inorder());
        assertEquals(7, map.size());
        assertEquals(false, map.isEmpty());
        assertEquals(8, ((Node<Integer, Integer>)getIterativeSearchMethod(map).invoke(map, 7)).parent.key);

        retVal = map.remove(7);
        assertEquals(8, retVal);
        assertEquals("[<6, 7>, <2, 3>, <1, 2>, <3, 4>, <8, 9>, <9, 10>]", map.preorder());
        assertEquals("[<1, 2>, <2, 3>, <3, 4>, <6, 7>, <8, 9>, <9, 10>]", map.inorder());
        assertEquals(6, map.size());
        assertEquals(false, map.isEmpty());
        assertEquals(6, ((Node<Integer, Integer>)getIterativeSearchMethod(map).invoke(map, 8)).parent.key);

        retVal = map.remove(8);
        assertEquals(9, retVal);
        assertEquals("[<6, 7>, <2, 3>, <1, 2>, <3, 4>, <9, 10>]", map.preorder());
        assertEquals("[<1, 2>, <2, 3>, <3, 4>, <6, 7>, <9, 10>]", map.inorder());
        assertEquals(5, map.size());
        assertEquals(false, map.isEmpty());
        assertEquals(6, ((Node<Integer, Integer>)getIterativeSearchMethod(map).invoke(map, 9)).parent.key);

        retVal = map.remove(9);
        assertEquals(10, retVal);
        assertEquals("[<2, 3>, <1, 2>, <6, 7>, <3, 4>]", map.preorder());
        assertEquals("[<1, 2>, <2, 3>, <3, 4>, <6, 7>]", map.inorder());
        assertEquals(4, map.size());
        assertEquals(false, map.isEmpty());
        assertEquals(6, ((Node<Integer, Integer>)getIterativeSearchMethod(map).invoke(map, 3)).parent.key);

        retVal = map.remove(1);
        assertEquals(2, retVal);
        assertEquals("[<3, 4>, <2, 3>, <6, 7>]", map.preorder());
        assertEquals("[<2, 3>, <3, 4>, <6, 7>]", map.inorder());
        assertEquals(3, map.size());
        assertEquals(false, map.isEmpty());
        assertEquals(3, ((Node<Integer, Integer>)getIterativeSearchMethod(map).invoke(map, 2)).parent.key);

        retVal = map.remove(3);
        assertEquals(4, retVal);
        assertEquals("[<6, 7>, <2, 3>]", map.preorder());
        assertEquals("[<2, 3>, <6, 7>]", map.inorder());
        assertEquals(2, map.size());
        assertEquals(false, map.isEmpty());
        assertEquals(6, ((Node<Integer, Integer>)getIterativeSearchMethod(map).invoke(map, 2)).parent.key);

        retVal = map.remove(6);
        assertEquals(7, retVal);
        assertEquals("[<2, 3>]", map.preorder());
        assertEquals("[<2, 3>]", map.inorder());
        assertEquals(1, map.size());
        assertEquals(false, map.isEmpty());
        assertEquals(null, ((Node<Integer, Integer>)getIterativeSearchMethod(map).invoke(map, 2)).parent);

        retVal = map.remove(2);
        assertEquals(3, retVal);
        assertEquals("[]", map.preorder());
        assertEquals("[]", map.inorder());
        assertEquals(0, map.size());
        assertEquals(true, map.isEmpty());

        System.out.println(map.toAsciiDrawing());

    }

    @Test
    public void testCosts01() {
        Pair<Integer, Integer>[] pairs = new Pair[6];
        for (int i = 0; i < 6; i++) {
            pairs[i] = new Pair(i, i);
        }
        AVLTreeMap<Integer, Integer> map = new AVLTreeMap<>(pairs, true);
        assertEquals(2.333333333333333, map.successfulSearchCost(), DELTA);
        assertEquals(2.857142857142857, map.unsuccessfulSearchCost(), DELTA);
    }
}

