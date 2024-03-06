
public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		q.insertLast(x);
		int[] temp = new int[q.size()];
		int s = q.size();
		for (int i = 0; i < s; i++) {
			temp[i] = q.removeFirst();
		}
		
		int n = temp.length; 
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (temp[j] < temp[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int t = temp[min_idx]; 
            temp[min_idx] = temp[i]; 
            temp[i] = t; 
        } 
		for (int j = 0; j < temp.length; j++) {
			q.insertLast(temp[j]);
		}
        
	}

	// implement this.
	public void pop() throws Exception {
//		if (q.isEmpty())
//			throw new EmptyQueueException();
//		int[] temp = new int[q.size()];
//		int s = q.size();
//		for (int i = 0; i < s; i++) {
//			temp[i] = q.removeFirst();
//		}
//		int low = temp[0];
//		int index = 0;
//		for (int i = 0; i < temp.length; i++) {
//			if (temp[i] < low) {
//				low = temp[i];
//				index = i;
//			}
//		}
//		for (int j = 0; j < temp.length; j++) {
//			if (j != index) {
//				q.insertLast(temp[j]);
//			}
//		}
		q.removeFirst();
	}

	// implement this
	public int top() throws Exception {
//		if (q.isEmpty())
//			throw new EmptyQueueException();
//		int[] temp = new int[q.size()];
//		int s = q.size();
//		for (int i = 0; i < s; i++) {
//			temp[i] = q.removeFirst();
//		}
//		int low = temp[0];
//		for (int i = 1; i < temp.length; i++) {
//			if (temp[i] < low) {
//				low = temp[i];
//			}
//		}
//		for (int j = 0; j < temp.length; j++) {
//			q.insertLast(temp[j]);
//		}
//		return low;
		return q.front();
	}

}
