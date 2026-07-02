package com.cognizant.jwtlearn.controller;

import com.cognizant.jwtlearn.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

// This controller intercepts the Basic Auth header, decodes the base64 user:pwd string,
// validates it, and returns the encrypted JWT token.
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        LOGGER.info("Start authenticate()");

        // 1. Read Authorization header and decode username/password
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String base64Credentials = authHeader.substring("Basic ".length());
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);

            // credentials will look like "user:pwd"
            String[] values = credentials.split(":", 2);
            String username = values[0];
            String password = values[1];

            // 2. Validate user (Hardcoded check based on requirement screenshot)
            if ("user".equals(username) && "pwd".equals(password)) {
                // 3. Generate token based on the user retrieved
                String token = JwtUtil.generateToken(username);
                Map<String, String> response = new HashMap<>();
                response.put("token", token);
                LOGGER.info("End authenticate() - Token generated");
                return response;
            }
        }

        throw new RuntimeException("Unauthorized: Invalid Credentials");
    }
}