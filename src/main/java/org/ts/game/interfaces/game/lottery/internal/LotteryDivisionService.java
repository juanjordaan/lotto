package org.ts.game.interfaces.game.lottery.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ts.game.domain.model.lottery.LotteryDraw;
import org.ts.game.infrastructure.persistence.jpa.LotteryGameJpaRepository;
import org.ts.game.interfaces.game.internal.DivisionService;
import org.ts.game.interfaces.game.lottery.rest.LotteryDivisionDto;

@Component
public class LotteryDivisionService extends DivisionService<LotteryDivisionDto> {

	@Autowired
	private LotteryGameJpaRepository lotteryGameJpaRepository;
	
	@Override
	public String getDivision(LotteryDivisionDto dto) {
		LotteryDraw lotteryDraw = lotteryGameJpaRepository.findById(dto.getGame().getId()).getDraw();
		
		Integer[] lotteryDraws = {lotteryDraw.getBall1(), lotteryDraw.getBall2(), lotteryDraw.getBall3(), lotteryDraw.getBall4(), lotteryDraw.getBall5(), lotteryDraw.getBall6()};
		Integer[] numbers = {dto.getBall1(), dto.getBall2(), dto.getBall3(), dto.getBall4(), dto.getBall5(), dto.getBall6()};
		
		List<Integer> matchingNumbers = getMatchingNumbers(lotteryDraws, numbers);
		Boolean bonusBallMatches = arrayContains(numbers, lotteryDraw.getBall7());
		
		return calculateDivision(matchingNumbers.size(), bonusBallMatches);
	}
	
	private String calculateDivision(Integer matches, Boolean bonusBallMatches) {
		if(matches == 6) {
			return "Winner - Division 1";
		} else if(matches == 5 && bonusBallMatches) {
			return "Winner - Division 2";
		} else if(matches == 5) {
			return "Winner - Division 3";
		} else if(matches == 4 && bonusBallMatches) {
			return "Winner - Division 4";
		} else if(matches == 4) {
			return "Winner - Division 5";
		} else if(matches == 3 && bonusBallMatches) {
			return "Winner - Division 6";
		} else if(matches == 3) {
			return "Winner - Division 7";
		} else if(matches == 2 && bonusBallMatches) {
			return "Winner - Division 8";
		}
		
		return "Not a Winner";
	}
}
