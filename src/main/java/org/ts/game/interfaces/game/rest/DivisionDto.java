package org.ts.game.interfaces.game.rest;

import javax.validation.constraints.NotNull;

import org.ts.game.interfaces.AbstractDto;

public abstract class DivisionDto<G extends GameDto> extends AbstractDto {

	@NotNull(message="Division Game can not be null")
	private G game;

	public G getGame() {
		return game;
	}

	public void setGame(G game) {
		this.game = game;
	}
}
