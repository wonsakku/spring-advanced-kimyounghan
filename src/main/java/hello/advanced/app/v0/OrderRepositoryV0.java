package hello.advanced.app.v0;

import java.nio.channels.IllegalSelectorException;

import org.springframework.stereotype.Repository;

import hello.advanced.util.CommonUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV0 {

	public void save(String itemId) {
		
//		저장 로직
		if("ex".equals(itemId)) {
			throw new IllegalStateException("예외 발생!");
		}
		
		CommonUtil.sleep(500);
		
		
	}
	
}
