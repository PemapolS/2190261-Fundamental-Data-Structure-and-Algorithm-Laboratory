
public class StudentList extends CDLinkedList {
    // you can write additional methods.

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) {
		if (i1 == null || !(i1 instanceof DListIterator) || i2 == null || !(i2 instanceof DListIterator))
			return;
		
		// point the earlier nodes to the new next nodes
		i1.currentNode.previousNode.nextNode = i2.currentNode;
		i2.currentNode.previousNode.nextNode = i1.currentNode;
		
		// point the start nodes to the new previous nodes
		DListNode previousTemp = i2.currentNode.previousNode;
		i2.currentNode.previousNode = i1.currentNode.previousNode;
		i1.currentNode.previousNode = previousTemp;
		
		i1.currentNode.nextNode.previousNode = i2.currentNode;
		i2.currentNode.nextNode.previousNode = i1.currentNode;
		
		DListNode nextTemp = i2.currentNode.nextNode;
		i2.currentNode.nextNode = i1.currentNode.nextNode;
		i1.currentNode.nextNode = nextTemp;
	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) throws Exception {
		if (i1 == null || !(i1 instanceof DListIterator) || lst.isEmpty())
			return;
		
		DListIterator in = new DListIterator(i1.currentNode.nextNode);
		DListIterator i2 = new DListIterator(lst.header.nextNode);
		DListIterator i3 = new DListIterator(lst.header.previousNode);
		
		i1.currentNode.nextNode = i2.currentNode;
		i2.currentNode.previousNode = i1.currentNode;
		
		in.currentNode.previousNode = i3.currentNode;
		i3.currentNode.nextNode = in.currentNode;
		
	}

	// implement this method
	public void gender(String g) throws Exception {
		DListIterator i1 = new DListIterator(this.header);
		DListIterator ih = new DListIterator(this.header);
		
		while (i1.currentNode.nextNode != this.header) {
			i1.next();
			if (((Student) i1.currentNode.data).getSex().equals(g)) {
				this.insert(i1.currentNode.data, ih);
				ih.next();
				i1.currentNode.previousNode.nextNode = i1.currentNode.nextNode;
				i1.currentNode.nextNode.previousNode = i1.currentNode.previousNode;
			}
		}
		
	}

}












