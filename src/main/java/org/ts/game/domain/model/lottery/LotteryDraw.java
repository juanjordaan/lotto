package org.ts.game.domain.model.lottery;

import javax.persistence.Entity;

import org.ts.game.domain.model.Draw;

@Entity
public class LotteryDraw extends Draw<LotteryGame> {
	private static final long serialVersionUID = -3602417195739591985L;

	private Integer ball1;
	private Integer ball2;
	private Integer ball3;
	private Integer ball4;
	private Integer ball5;
	private Integer ball6;
	private Integer ball7;
	
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
	public Integer getBall7() {
		return ball7;
	}
	public void setBall7(Integer ball7) {
		this.ball7 = ball7;
	}
	@Override
	public String toString() {
		return "LotteryDraw [ball1=" + ball1 + ", ball2=" + ball2 + ", ball3=" + ball3 + ", ball4=" + ball4 + ", ball5="
				+ ball5 + ", ball6=" + ball6 + ", ball7=" + ball7 + ", getDate()=" + getDate() + ", getGame()="
				+ getGame() + ", getId()=" + getId() + ", getVersion()=" + getVersion() + "]";
	}
	
	
}
