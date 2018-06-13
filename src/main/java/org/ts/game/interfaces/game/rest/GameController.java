package org.ts.game.interfaces.game.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author juan
 *
 */
@RequestMapping(path="/api/v1")
public abstract class GameController<O extends GameDto, D extends DrawDto<O>, V extends DivisionDto<O>> {
	public abstract ResponseEntity<O> scheduleInstance(O dto);
	public abstract ResponseEntity<D> draw(D dto);
	public abstract ResponseEntity<String> division(V dto);
}
