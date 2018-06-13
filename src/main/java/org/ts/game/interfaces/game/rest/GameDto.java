package org.ts.game.interfaces.game.rest;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.ts.game.interfaces.AbstractDto;

/**
 * @author juan
 *
 */
public abstract class GameDto extends AbstractDto {
	@NotNull(message="Game name can not be null")
	@Size(min=2, max=200, message="Game Name size is min 2 nd max 200")
	private String name;
	
	@NotNull(message="Game date can not be null")
	private Date date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
