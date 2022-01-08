package hello.advanced.trace.strategy;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.strategy.code.template.Callback;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateCallbackTest {

	/*
	 * 템플릿 콜백 패턴
	 */
	@Test
	void callbackV1() {
		TimeLogTemplate template = new TimeLogTemplate();
		template.execute(()->log.info("비즈니스 로직1 실행"));
		
		TimeLogTemplate template2 = new TimeLogTemplate();
		template2.execute(new Callback() {
			@Override
			public void call() {
				log.info("비즈니스 로직2 실행");
			}
		});
		
	}
}













