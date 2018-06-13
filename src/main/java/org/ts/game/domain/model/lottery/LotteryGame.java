package org.ts.game.domain.model.lottery;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.ts.game.domain.model.Game;

/**
 * @author juan
 *
 */
@Entity
public class LotteryGame extends Game {
	private static final long serialVersionUID = -4013932342959709716L;
	
	@OneToOne(mappedBy="game")
	private LotteryDraw draw;
	
	public LotteryDraw getDraw() {
		return draw;
	}

	public void setDraw(LotteryDraw draw) {
		this.draw = draw;
	}

	@Override
	public String toString() {
		return "Lottery [getName()=" + getName() + ", getDate()=" + getDate() + ", getId()=" + getId()
				+ ", getVersion()=" + getVersion() + "]";
	}
}
