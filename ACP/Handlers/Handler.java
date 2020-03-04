package Handlers;

import java.util.HashMap;

/**
 * This is a Handler interface created to be a contract within the Handler classes of the Application Controller
 */
public interface Handler {
	/**
	 * All classes implementing this interface need to implement the this method.
	 * @param data
	 * @return Object
	 */
	public Object handleIt(HashMap<String, Object> data);
}
