package org.ts.game.application.error;

/**
 * @author juan
 *
 */
public class ErrorFactory {
	public static Error unhandledError(Integer code, String description) {
		// TODO - messages must be looked up from messages.properties using i18n
		return new Error(code, "An Error Occurred", description);
	}
}
