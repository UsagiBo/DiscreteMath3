/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discretemath4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Rumyana
 */
public class Sets {
    public static void main(String... args) throws Exception {

        List<Integer> list1 = new ArrayList<>(Arrays.asList(2, 6, 9, 15, 30));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(6, 9, 14, 25, 30));

        System.out.println("Set A : " + list1);
        System.out.println("Set B : " + list2);
        System.out.println("");
        System.out.println("Membership : 1 for True, -1 for False) : " + new Sets().membership(list1, list2));
        System.out.println("Intersection : " + new Sets().intersection(list1, list2));
        System.out.println("Union : " + new Sets().union(list1, list2));
        System.out.println("Difference: " + new Sets().difference(list1, list2));
        System.out.println("Complement of A : " + new Sets().complement(list1, list2));
        System.out.println("Are the sets subsets or equal or undeterminable? : " + new Sets().membershipRelation(list1, list2));
    }

    public <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);
        return new ArrayList<>(set);
    }

    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<>();
        for (T t : list1) {
            if (list2.contains(t)) {
                list.add(t);
            }
        }
        return list;
    }

    public <T> int membership(List<T> list1, List<T> list2) {
        List<T> list;
        if (list1.size() > list2.size()) {
            list = intersection(list1, list2);
        } else {
            list = intersection(list2, list1);
        }

        if (!list.isEmpty()) {
            if (list.size() == list1.size()) {

                return 1;

            } else {
                return -1;
            }

        } else {
            return -1;
        }

    }

    public <T> List<T> difference(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<>();
        set.addAll(list1);
        set.removeAll(list2);
        return new ArrayList<>(set);
    }

    public <T> List<T> complement(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<>();
        set.addAll(list2);
        set.removeAll(list1);
        return new ArrayList<>(set);
    }

    public <T> int membershipRelation(List<T> list1, List<T> list2) {
        //which one is the bigger list
        int result = undeterminable(list1, list2);
        if (result == 2) {
            return 2;
        } else {
            List<T> list;
            list = intersection(list1, list2);
            if (list1.size() == list2.size() && list.size() == list1.size()) {
                //for loop for checking same elemnts

                return 0;
            }

            if (list1.size() == list.size() && list1.size() < list2.size()) {
                return -1;
            } else if (list2.size() == list.size() && list1.size() > list2.size()) {
                return 1;
            }

        }

        return -2;
    }

    public <T> int undeterminable(List<T> list1, List<T> list2) {
        int big = Integer.MAX_VALUE;
        int small = Integer.MIN_VALUE;

        if ((list1.size() > big) || (list1.size() < small) || (list2.size() > big) || (list2.size() < small)) {
            return 2;
        } else {
            return -2;
        }
    }
}
