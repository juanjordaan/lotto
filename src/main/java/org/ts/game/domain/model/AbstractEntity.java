package org.ts.game.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * @author juan
 *
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {
	private static final long serialVersionUID = -8090044558860617385L;
	
	@Id
	@GeneratedValue
	protected Long id;
	
	@Version
	@Column(nullable=false, columnDefinition="integer default 1")
	protected Long version;

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
