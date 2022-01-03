package hello.advanced.app.v0;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderServiceV0 {

	private final OrderRepositoryV0 orderRepository;
	
	public void orderItem(String itemId) {
		orderRepository.save(itemId);
	}
}
