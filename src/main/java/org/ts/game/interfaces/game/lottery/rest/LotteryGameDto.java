package org.ts.game.interfaces.game.lottery.rest;


import org.ts.game.interfaces.game.rest.GameDto;

/**
 * @author juan
 *
 */
public class LotteryGameDto extends GameDto {

	@Override
	public String toString() {
		return "LotteryGameDto [getName()=" + getName() + ", getDate()=" + getDate() + ", getId()=" + getId()
				+ ", getVersion()=" + getVersion() + "]";
	}
}
