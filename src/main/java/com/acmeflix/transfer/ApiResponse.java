package com.acmeflix.transfer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class ApiResponse<T> implements Serializable {
	String transactionId = UUID.randomUUID().toString().toUpperCase();

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
	LocalDateTime createdAt = LocalDateTime.now();

	T data;

	ApiError apiError;
}
