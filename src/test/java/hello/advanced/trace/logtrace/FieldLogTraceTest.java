package hello.advanced.trace.logtrace;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.TraceStatus;

class FieldLogTraceTest {

	FieldLogTrace trace = new FieldLogTrace();
	
	@Test
	void begin_end_level2() {
		TraceStatus status = trace.begin("hello1");
		TraceStatus status2 = trace.begin("hello2");
		trace.end(status2);
		trace.end(status);
		
	}

	
	@Test
	void baegin_exception_level2() {
		TraceStatus status = trace.begin("hello1");
		TraceStatus status2 = trace.begin("hello2");
		trace.exception(status2, new IllegalStateException());
		trace.exception(status, new IllegalStateException());
		
	}
}
