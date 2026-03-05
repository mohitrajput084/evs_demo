package com.cpgm.evs.security;

import com.cpgm.evs.dto.ApiErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException ex) throws IOException {

        ApiErrorResponse error = ApiErrorResponse.builder()
                .status(HttpServletResponse.SC_FORBIDDEN)
                .message("Access denied")
                .timestamp(LocalDateTime.now())
                .build();

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        objectMapper.writeValue(response.getOutputStream(), error);
    }
}