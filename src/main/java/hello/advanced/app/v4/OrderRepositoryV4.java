package hello.advanced.app.v4;

import org.springframework.stereotype.Repository;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import hello.advanced.util.CommonUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV4 {

	private final LogTrace trace;
	
	public void save(String itemId) {


		AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
			@Override
			protected Void call() {
					// 저장 로직
				if(itemId.equals("ex")) {
					throw new IllegalStateException("예외 발생!");
				}
				CommonUtil.sleep(1000);
				return null;
			}
		};
		
		template.execute("OrderRepository.save()");
	}

}


























