package hello.advanced.app.v2;

import org.springframework.stereotype.Repository;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import hello.advanced.util.CommonUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV2 {

	private final HelloTraceV2 trace;
	
	public void save(TraceId traceId, String itemId) {
		
		TraceStatus status = null;
		
		try {
			status = trace.beginSync(traceId, "OrderRepositoryV2.request()");

			// 저장 로직
			if("ex".equals(itemId)) {
				throw new IllegalStateException("예외 발생!");
			}
			CommonUtil.sleep(1000);
			
			trace.end(status);

		} catch (Exception e) {
			trace.exception(status , e);
			throw e;
		}
		
	}
	
}
