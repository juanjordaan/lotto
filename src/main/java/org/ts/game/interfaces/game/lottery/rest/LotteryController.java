package org.ts.game.interfaces.game.lottery.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ts.game.domain.model.lottery.LotteryDraw;
import org.ts.game.domain.model.lottery.LotteryGame;
import org.ts.game.infrastructure.persistence.jpa.LotteryDrawJpaRepository;
import org.ts.game.infrastructure.persistence.jpa.LotteryGameJpaRepository;
import org.ts.game.interfaces.game.lottery.internal.LotteryDivisionService;
import org.ts.game.interfaces.game.rest.GameController;

/**
 * @author juan
 *
 */
@RequestMapping(path="/lottery")
@Controller
public class LotteryController extends GameController<LotteryGameDto, LotteryDrawDto, LotteryDivisionDto> {
	private static final Logger LOG = LoggerFactory.getLogger(LotteryController.class);
	@Autowired
	private LotteryGameJpaRepository lotteryGameJpaRepository;
	
	@Autowired
	private LotteryDrawJpaRepository lotteryDrawJpaRepository;
	
	@Autowired
	private LotteryGameAssembler lotteryGameAssembler;
	
	@Autowired
	private LotteryDrawAssembler lotteryDrawAssembler;
	
	@Autowired
	private LotteryDivisionService lotteryDivisionService;
	
	@Override
	@RequestMapping(path="/instance",
		produces = {APPLICATION_JSON_VALUE},
		consumes = {APPLICATION_JSON_VALUE},
		method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<LotteryGameDto> scheduleInstance(@Valid @RequestBody LotteryGameDto lotteryDto) {
		LOG.debug("Received new Lottery Instance Request");
		
		LotteryGame lottery = lotteryGameJpaRepository.create(lotteryGameAssembler.toEntity(lotteryDto));
		
		lotteryDto = lotteryGameAssembler.toDto(lottery);
		
		LOG.info("Returning new Lottery : " + lotteryDto);
		
		return new ResponseEntity<LotteryGameDto>(lotteryDto, HttpStatus.CREATED);
	}

	@Override
	@RequestMapping(path="/draw",
		produces = {APPLICATION_JSON_VALUE},
		consumes = {APPLICATION_JSON_VALUE},
		method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<LotteryDrawDto> draw(@Valid @RequestBody LotteryDrawDto dto) {
		LOG.info("Received new Lottery Draw Request");
		LotteryDraw entity = lotteryDrawJpaRepository.create(lotteryDrawAssembler.toEntity(dto));
		
		dto = lotteryDrawAssembler.toDto(entity);
		
		LOG.info("Returning new Lottery Draw : " + dto);
		
		return new ResponseEntity<LotteryDrawDto>(dto, HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/division",
			produces = {APPLICATION_JSON_VALUE},
			consumes = {APPLICATION_JSON_VALUE},
			method=RequestMethod.POST)
		@ResponseBody
		public ResponseEntity<String> division(@Valid @RequestBody LotteryDivisionDto dto) {
		LOG.info("Received new Lottery Division Request");
		
		// TODO - LotteryDivisionDto must have an equivalent entity and the result of the draw is to be persisted.
		String division = lotteryDivisionService.getDivision(dto);
		
		LOG.info("Returning new Lottery Division : " + division);
		
		return new ResponseEntity<String>(division, HttpStatus.OK);
	}
}
