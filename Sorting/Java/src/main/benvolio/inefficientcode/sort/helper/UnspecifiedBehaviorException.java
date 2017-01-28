package benvolio.inefficientcode.sort.helper;

/**
 * This error should only be used for unspecified behavior in methods.
 * For instance, trying to determine if an empty array (not a null one) is sorted
 * is unspecified behavior.
 * 
 * @author Kardyne
 *
 */
public class UnspecifiedBehaviorException extends RuntimeException {

	private static final long serialVersionUID = -4857673029836154187L;

	public UnspecifiedBehaviorException(final String message) {
		super(message);
	}
}
