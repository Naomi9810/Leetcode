package com.goo.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Time Complexity: O(n)
 * <p>
 * Space Complexity: O(n)
 * <p>
 * Hints:
 * <p> 1. cars[i] = [position i, speed i] // the position is sorted, so position - i < position -
 * i+1
 * <p> 2. answer[i] is the time, in seconds, ith car collides with the next car,
 * or -1 if the car does not collide with the next car/ or be caught.
 * <p> 3. How to catch speed1 > speed2 &&  pos 1 <= pos2,  car1 will collide car2
 * we maintain a stack of car idx where their collision time is strict decreasing
 */
public class LC_1776_Car_Fleet_II {

    public double[] getCollisionTimes(int[][] cars) {
        int numOfCars = cars.length;
        double[] res = new double[numOfCars];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = numOfCars - 1; i >= 0; i--) {
            // looking from the last car this is target-nearest car
            res[i] = -1;
            int position = cars[i][0];
            int speed = cars[i][1];
            while (stack.size() > 0) {
                int pre = stack.peekLast();
                int position2 = cars[pre][0];
                int speed2 = cars[pre][1];
                if (speed <= speed2
                        || (double) (position2 - position) / (speed - speed2) >= res[pre] && res[pre] > 0) {
                    // car2 can't catch the pre car, or cars2 will collide with car1 and car1 is already collide, remove pre car
                    stack.pollLast();
                    // poll any pre car which cur car can't catch up
                } else {
                    break;
                }
            }
            if (stack.size() > 0) {
                // able to catch up and hit case:
                int j = stack.peekLast();
                int position2 = cars[j][0];
                int speed2 = cars[j][1];
                res[i] = (double) (position2 - position) / (speed - speed2);
            }
            stack.add(i); // put index in the stack

        }
        return res;
    }

}
