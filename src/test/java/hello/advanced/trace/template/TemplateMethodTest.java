package hello.advanced.trace.template;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodTest {

	@Test
	void templateMethodV0() {
		logic1();
		logic2();
	}
	
	private void logic1() {
		long startTime = System.currentTimeMillis();
		
		//비즈니스 로직 실행
		log.info("비즈니스 로직1 실행");
		//비즈니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}", resultTime);
	}
	
	private void logic2() {
		long startTime = System.currentTimeMillis();
		
		//비즈니스 로직 실행
		log.info("비즈니스 로직2 실행");
		//비즈니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}", resultTime);
	}
	
	@Test
	@DisplayName("템플릿 메서드 패턴 적용 - V1")
	void templateMethodV1() {
		AbstractTemplate template = new SubClassLogic1();
		template.execute();

		template = new SubClassLogic2();
		template.execute();
	}
	
	
	@Test
	@DisplayName("템플릿 메서드 패턴 적용 - V2 - 익명 내부 클래스")
	void templateMethodV2() {
	
		AbstractTemplate template1 = new AbstractTemplate() {
			
			@Override
			public void call() {
				log.info("비즈니스 로직 1 실행");
			}
		};
		
		log.info("클래스 이름1={}", template1.getClass());
		template1.execute();
		
		AbstractTemplate template2 = new AbstractTemplate() {
			
			@Override
			public void call() {
				log.info("비즈니스 로직2 실행");				
			}
		};
		
		log.info("클래스 이름2={}", template2.getClass());
		template2.execute();
		
	}
}














