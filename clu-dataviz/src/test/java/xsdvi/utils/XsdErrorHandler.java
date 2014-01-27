package xsdvi.utils;

import org.w3c.dom.DOMError;
import org.w3c.dom.DOMErrorHandler;


public class XsdErrorHandler implements DOMErrorHandler {
	
	/** {@inheritDoc} */
	@Override
	public boolean handleError(DOMError error) {
		int severity = error.getSeverity();
		if (severity == DOMError.SEVERITY_FATAL_ERROR) {
			System.out.println("[xs-fatal-error]: " + errorMessage(error));
			System.exit(1);
		} else if (severity == DOMError.SEVERITY_ERROR) {
			System.out.println("[xs-error]: " + errorMessage(error));
		} else if (severity == DOMError.SEVERITY_WARNING) {
			System.out.println("[xs-warning]: " + errorMessage(error));
		}
		return true;
	}

	/**
	 * @param error
	 * @return
	 */
	private String errorMessage(DOMError error) {
		return error.getMessage() + " (line: " + error.getLocation().getLineNumber() + ")";
	}
}