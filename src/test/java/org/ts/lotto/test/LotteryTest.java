package org.ts.lotto.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ts.game.GameApplication;
import org.ts.game.interfaces.game.lottery.rest.LotteryDivisionDto;
import org.ts.game.interfaces.game.lottery.rest.LotteryDrawDto;
import org.ts.game.interfaces.game.lottery.rest.LotteryGameDto;

/**
 * @author juan
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT, classes=GameApplication.class)
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class LotteryTest extends AbstractGameTest<LotteryGameDto, LotteryDrawDto, LotteryDivisionDto> {
	private static final Logger LOG = LoggerFactory.getLogger(LotteryTest.class);
	private static final String LOTTERY_NAME = "SA Lottery";

	@Test
	public void scheduleAndRunTest_Passes() {
		LOG.info("\n******************************************* Starting new Game ******************************************* ");
		// create an instance
		Date drawDate = new Date();
		LotteryGameDto lotteryGameDto = new LotteryGameDto();
		lotteryGameDto.setName(LOTTERY_NAME);
		lotteryGameDto.setDate(drawDate);
		
		lotteryGameDto = postForNewInstance(lotteryGameDto);
		assertThat(lotteryGameDto.getName()).isEqualTo(LOTTERY_NAME);
		assertThat(lotteryGameDto.getDate()).isEqualTo(drawDate);
		
		// create a draw
		LotteryDrawDto lotteryDrawDto = new LotteryDrawDto();
		lotteryDrawDto.setBall1(29);
		lotteryDrawDto.setBall2(15);
		lotteryDrawDto.setBall3(22);
		lotteryDrawDto.setBall4(41);
		lotteryDrawDto.setBall5(19);
		lotteryDrawDto.setBall6(4);
		lotteryDrawDto.setBall7(17);
		lotteryDrawDto.setGame(lotteryGameDto);
		lotteryDrawDto.setDate(drawDate);
		
		lotteryDrawDto = postForNewDraw(lotteryDrawDto);
		
		// test for a division
		LotteryDivisionDto divisionDto = new LotteryDivisionDto();
		divisionDto.setGame(lotteryGameDto);
		divisionDto.setBall1(3);
		divisionDto.setBall2(15);
		divisionDto.setBall3(19);
		divisionDto.setBall4(22);
		divisionDto.setBall5(29);
		divisionDto.setBall6(41);
		
		String division = postForDivision(divisionDto);
		
		LOG.info("Test Lottery Division="+division);
		
		LOG.info("\n******************************************* Finished new Game ******************************************* ");
	}
	
	@Override
	protected String getGameInstancePath() {
		return "/lottery/instance";
	}
	
	@Override
	protected String getGameDrawPath() {
		return "/lottery/draw";
	}
	
	@Override
	protected String getGameDivisionPath() {
		return "/lottery/division";
	}
}

