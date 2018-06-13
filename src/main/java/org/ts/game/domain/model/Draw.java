package org.ts.game.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author juan
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Draw<G extends Game> extends AbstractEntity {
	private static final long serialVersionUID = -1260940897415719958L;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToOne(targetEntity=Game.class)
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
