package hello.advanced.trace.threadlocal;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.threadlocal.code.FieldService;
import hello.advanced.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldServiceTest {

	private FieldService fieldService = new FieldService();
	
	@Test
	void field() {
		log.info("main start");
		Runnable userA = () -> fieldService.logic("userA");
		Runnable userB = () -> fieldService.logic("userB");
		
		Thread threadA = new Thread(userA);
		threadA.setName("thread-A");
		Thread threadB = new Thread(userB);
		threadB.setName("thread-B");
		
		threadA.start();
//		CommonUtil.sleep(2000); // 동시성 문제 발생 X
		CommonUtil.sleep(100); // 동시성 문제 발생 
		threadB.start();
		CommonUtil.sleep(2000); // main thread 종료 방지
		log.info("main exit");
	}
}
