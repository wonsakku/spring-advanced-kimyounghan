package hello.advanced.app.v1;

import org.springframework.stereotype.Repository;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import hello.advanced.util.CommonUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV1 {

	private final HelloTraceV1 trace;

	
	public void save(String itemId) {
		TraceStatus status = null;

		
		try {
			status = trace.begin("OrderRepository.save()");	
			
			// 저장 로직
			if(itemId.equals("ex")) {
				throw new IllegalStateException("예외 발생!");
			}
			CommonUtil.sleep(1000);

			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}

	}

}


























