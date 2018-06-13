package org.ts.game.interfaces.game.lottery.rest;

import static org.ts.game.interfaces.game.lottery.internal.LotteryConstants.MIN;
import static org.ts.game.interfaces.game.lottery.internal.LotteryConstants.MIN_MESSAGE;
import static org.ts.game.interfaces.game.lottery.internal.LotteryConstants.MAX;
import static org.ts.game.interfaces.game.lottery.internal.LotteryConstants.MAX_MESSAGE;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


import org.ts.game.interfaces.game.rest.DivisionDto;

public class LotteryDivisionDto extends DivisionDto<LotteryGameDto> {
	@Min(value=MIN, message=MIN_MESSAGE)
	@Max(value=MAX, message=MAX_MESSAGE)
	private Integer ball1;
	@Min(value=MIN, message=MIN_MESSAGE)
	@Max(value=MAX, message=MAX_MESSAGE)
	private Integer ball2;
	@Min(value=MIN, message=MIN_MESSAGE)
	@Max(value=MAX, message=MAX_MESSAGE)
	private Integer ball3;
	@Min(value=MIN, message=MIN_MESSAGE)
	@Max(value=MAX, message=MAX_MESSAGE)
	private Integer ball4;
	@Min(value=MIN, message=MIN_MESSAGE)
	@Max(value=MAX, message=MAX_MESSAGE)
	private Integer ball5;
	@Min(value=MIN, message=MIN_MESSAGE)
	@Max(value=MAX, message=MAX_MESSAGE)
	private Integer ball6;

	public Integer getBall1() {
		return ball1;
	}

	public void setBall1(Integer ball1) {
		this.ball1 = ball1;
	}

	public Integer getBall2() {
		return ball2;
	}

	public void setBall2(Integer ball2) {
		this.ball2 = ball2;
	}

	public Integer getBall3() {
		return ball3;
	}

	public void setBall3(Integer ball3) {
		this.ball3 = ball3;
	}

	public Integer getBall4() {
		return ball4;
	}

	public void setBall4(Integer ball4) {
		this.ball4 = ball4;
	}

	public Integer getBall5() {
		return ball5;
	}

	public void setBall5(Integer ball5) {
		this.ball5 = ball5;
	}

	public Integer getBall6() {
		return ball6;
	}

	public void setBall6(Integer ball6) {
		this.ball6 = ball6;
	}

	@Override
	public String toString() {
		return "LotteryDivisionDto [ball1=" + ball1 + ", ball2=" + ball2 + ", ball3=" + ball3 + ", ball4=" + ball4
				+ ", ball5=" + ball5 + ", ball6=" + ball6 + ", getGame()=" + getGame() + ", getId()=" + getId()
				+ ", getVersion()=" + getVersion() + "]";
	}
}
