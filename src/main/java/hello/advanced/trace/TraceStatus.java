package hello.advanced.trace;

public class TraceStatus {

	private TraceId traceId;
	private Long startTimeMs;
	private String message;
	
	public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
		this.traceId = traceId;
		this.startTimeMs = startTimeMs;
		this.message = message;
	}
	
	public Long getStartTimeMs() {
		return this.startTimeMs;
	}

	public TraceId getTraceId() {
		return this.traceId;
	}

	public String getMessage() {
		return this.message;
	}
	
	
}
