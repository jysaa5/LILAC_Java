package chapter11.collections.framework;

import java.util.PriorityQueue;
import java.util.Queue;

// p.612
public class PriorityQueue_01 {
	
	 public static void main(String[] args) {
		 
		 Queue<Integer> pq = new PriorityQueue<Integer>();
		 
		 // pq.offer(new Integer(3)); ����ڽ�
		 pq.offer(3);
		 pq.offer(1);
		 pq.offer(5);
		 pq.offer(2);
		 pq.offer(4);
		 
		 // pq�� ���� �迭�� ���
		 System.out.println(pq);
		 
		 Object obj = null;
		 
		 //PriorityQueue�� ����� ��Ҹ� �ϳ��� ������.
		 while((obj = pq.poll()) != null) {
			 System.out.println(obj);
		 }
	 }

}
