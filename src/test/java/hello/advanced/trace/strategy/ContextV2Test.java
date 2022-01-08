package hello.advanced.trace.strategy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.strategy.code.strategy.ContextV2;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2Test {

	
	/**
	 * 전략 패턴 적용
	 */
	@Test
	void strategyV1() {
		ContextV2 context1 = new ContextV2();
		context1.execute(()->log.info("비즈니스 로직 1 실행"));
		
		ContextV2 context2 = new ContextV2();
		context2.execute(new StrategyLogic2());
		
		ContextV2 context3 = new ContextV2();
		context3.execute(new Strategy() {
			
			@Override
			public void call() {
				log.info("비즈니스 로직22 실행");
			}
		});
	}
}

























