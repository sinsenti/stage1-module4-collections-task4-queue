package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DishOrderDeterminer {
  public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
    Queue<Integer> queue = new LinkedList<>();
    List<Integer> eatenOrder = new ArrayList<>();
    for (int i = 1; i <= numberOfDishes; i++) {
      queue.offer(i);
    }
    while (!queue.isEmpty()) {
      for (int i = 0; i < everyDishNumberToEat - 1; i++) {
        queue.offer(queue.poll());
      }
      eatenOrder.add(queue.poll());
    }
    return eatenOrder;
  }
}
