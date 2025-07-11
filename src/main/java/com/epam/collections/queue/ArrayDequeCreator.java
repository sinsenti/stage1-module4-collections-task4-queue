package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {

  public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
    ArrayDeque<Integer> resultDeque = new ArrayDeque<>();

    for (int i = 0; i < 2; i++) {
      resultDeque.addLast(firstQueue.poll());
    }
    for (int i = 0; i < 2; i++) {
      resultDeque.addLast(secondQueue.poll());
    }

    boolean isFirstPlayersTurn = true;

    while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
      firstQueue.add(resultDeque.pollLast());
      for (int i = 0; i < 2; i++) {
        if (!firstQueue.isEmpty()) {
          resultDeque.addLast(firstQueue.poll());
        }
      }
      secondQueue.add(resultDeque.pollLast());
      for (int i = 0; i < 2; i++) {
        if (!secondQueue.isEmpty()) {
          resultDeque.addLast(secondQueue.poll());
        }
      }
      isFirstPlayersTurn = !isFirstPlayersTurn;
    }

    return resultDeque;
  }

}
