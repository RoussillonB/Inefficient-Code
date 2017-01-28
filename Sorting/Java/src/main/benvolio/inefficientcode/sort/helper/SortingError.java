package benvolio.inefficientcode.sort.helper;

/**
 * An error that should be used in two cases only:
 * - if there was an error while sorting
 * - if the array was not sorted after a call to a sort method 
 * 
 * @author Kardyne
 *
 */
public class SortingError extends Exception {

	private static final long serialVersionUID = -7173805116580611536L;

	public SortingError(final String message) {
		super(message);
	}
}
