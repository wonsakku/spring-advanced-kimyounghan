package hello.advanced.app.v3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class OrderControllerV3 {

	private final OrderServiceV3 orderService;
	private final LogTrace trace;
	
	@GetMapping("/v3/request")
	public String request(String itemId) {
		
		TraceStatus status = null;
		
		try {
			status = trace.begin("OrderController.request()");
			orderService.orderItem(status.getTraceId(), itemId);
			trace.end(status);
			return "OK";
		} catch (Exception e) {
			trace.exception(status, e);
//			return e.getMessage();
			throw e;
		}
	}
}



