package org.ts.game.infrastructure.persistence.jpa;

import org.springframework.stereotype.Repository;
import org.ts.game.domain.model.lottery.LotteryDraw;

/**
 * @author juan
 *
 */
@Repository
public class LotteryDrawJpaRepository extends AbstractJPARepository<LotteryDraw, Long> {

}
