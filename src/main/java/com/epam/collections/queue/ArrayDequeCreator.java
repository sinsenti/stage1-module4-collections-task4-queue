package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
  public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
    ArrayDeque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < 2; i++) {
      deque.addLast(firstQueue.poll());
    }
    for (int i = 0; i < 2; i++) {
      deque.addLast(secondQueue.poll());
    }

    boolean firstPlayersTurn = true;
    while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
      if (firstPlayersTurn) {
        if (!deque.isEmpty()) {
          firstQueue.add(deque.pollFirst());
        }
        for (int i = 0; i < 2; i++) {
          if (!firstQueue.isEmpty()) {
            deque.addLast(firstQueue.poll());
          } else if (firstQueue.isEmpty() && secondQueue.isEmpty()) {
            break;
          }
        }
      } else {
        if (!deque.isEmpty()) {
          secondQueue.add(deque.pollFirst());
        }
        for (int i = 0; i < 2; i++) {
          if (!secondQueue.isEmpty()) {
            deque.addLast(secondQueue.poll());
          }
        }
      }
      firstPlayersTurn = !firstPlayersTurn;
    }
    return deque;
  }
}
