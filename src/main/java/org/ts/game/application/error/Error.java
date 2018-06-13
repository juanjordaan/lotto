package org.ts.game.application.error;

/**
 * @author juan
 *
 */
public class Error extends Object {

	// Protocol agnostic code
	private Integer code;
	// i18n message or a documented code
	private String message;
	// Developer message
	private String description;
	
	protected Error() {
		
	}

	public Error(Integer code, String message, String description) {
		this.code = code;
		this.message = message;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
