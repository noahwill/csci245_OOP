package hmllm;


/**
 * LinkedList Node class to store the necessary 
 * data of the node in the Map.
 * 
 * @author noahwill
 *
 */
public class Node {
	private String key;
	private String val;
	private Node link;
	
	/**
	 * Constructor for the Node Class
	 *
	 * @param key
	 * @param value
	 */
	public Node(String key, String val, Node link) {
		this.key = key;
		this.setVal(val);
		this.setLink(link);
	}

	/**
	 * Gets the Value of the key/value pair.
	 * 
	 * @return
	 */
	public String getVal() {
		return val;
	}

	/**
	 * Sets the Value of the key/value pair.
	 * 
	 * @param value
	 */
	public void setVal(String val) {
		this.val = val;
	}

	/** 
	 * Gets the Key of the key/value pair. 
	 * 
	 * @return
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Gets the Node that the Node is linked to.
	 * 
	 * @return
	 */
	public Node getLink() {
		return link;
	}

	/**
	 * Sets the Node that the Node is linked to.
	 * 
	 * @param link
	 */
	public void setLink(Node link) {
		this.link = link;
	}

}
