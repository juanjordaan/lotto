package org.ts.game.interfaces;


/**
 * @author juan
 *
 */
public abstract class AbstractDto {

	private Long id;
	
	private Long version;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
}
