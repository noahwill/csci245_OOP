package hmllm;

import java.util.Iterator;

public class MapIterator implements Iterator<String> {
	
	private Node head;
	private Node position = head;
	
	public boolean hasNext() {
		if(position != null)
			return true;
		else
			return false;
	}

	public String next() {
		if(this.hasNext())
			return "hey";
		return null;
	}

}
