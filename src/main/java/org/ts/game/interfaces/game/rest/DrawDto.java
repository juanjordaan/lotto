package org.ts.game.interfaces.game.rest;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.ts.game.interfaces.AbstractDto;

public abstract class DrawDto<G extends GameDto> extends AbstractDto {
	
	@NotNull(message="Draw date can not be null")
	private Date date;
	
	@NotNull(message="Draw game can not be null")
	private G game;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public G getGame() {
		return game;
	}
	public void setGame(G game) {
		this.game = game;
	}
}
