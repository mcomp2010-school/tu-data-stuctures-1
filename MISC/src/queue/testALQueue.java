package queue;

import mid.ALQueue;

public class testALQueue  {

	static ALQueue<String> Queue1 = new ALQueue<String>();
	public static void main(String[] args) {
		Queue1.Enqueue("1");
		Queue1.Enqueue("2");
		Queue1.Enqueue("3");
 
		while(!Queue1.isEmpty()){
			System.out.println(Queue1.Dequeue());
		}
		
	}

}
