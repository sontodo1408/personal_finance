package vn.io.sontd.personal_finance.server.service;

import jakarta.servlet.http.HttpServletRequest;
import vn.io.sontd.personal_finance.server.dto.auth.TokenInfoDTO;

public interface JwtService {
    String generateJwtToken(TokenInfoDTO tokenInfo);

    String getUsername(String token);

    String getPassword(String token);

    String getAuthToken(HttpServletRequest httpReq);

    boolean validateJwtToken(String authToken);
}
