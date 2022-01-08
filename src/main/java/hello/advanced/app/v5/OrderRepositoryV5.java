package hello.advanced.app.v5;

import org.springframework.stereotype.Repository;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import hello.advanced.util.CommonUtil;
import lombok.RequiredArgsConstructor;

@Repository
public class OrderRepositoryV5 {

	private final TraceTemplate traceTemplate;
	
	public OrderRepositoryV5(LogTrace logTrace) {
		this.traceTemplate = new TraceTemplate(logTrace);
	}

	public void save(String itemId) {

		traceTemplate.execute("OrderRepository.save()", () -> {
			// 저장 로직
			if(itemId.equals("ex")) {
				throw new IllegalStateException("예외 발생!");
			}
			CommonUtil.sleep(1000);
			return null;
		});
	}

}


























