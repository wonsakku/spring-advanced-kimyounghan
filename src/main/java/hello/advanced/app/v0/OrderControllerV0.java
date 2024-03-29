package hello.advanced.app.v0;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class OrderControllerV0 {

	private final OrderServiceV0 orderService;
	
	@GetMapping("/v0/request")
	public String request(String itemId) {
		try {
			orderService.orderItem(itemId);
			return "OK";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
