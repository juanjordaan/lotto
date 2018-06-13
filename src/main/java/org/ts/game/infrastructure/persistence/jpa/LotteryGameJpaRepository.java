package org.ts.game.infrastructure.persistence.jpa;

import org.springframework.stereotype.Repository;
import org.ts.game.domain.model.lottery.LotteryGame;

/**
 * @author juan
 *
 */
@Repository
public class LotteryGameJpaRepository extends AbstractJPARepository<LotteryGame, Long> {

}
