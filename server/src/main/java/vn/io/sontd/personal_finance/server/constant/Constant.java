package vn.io.sontd.personal_finance.server.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
    // SECURITY
    public static final String[] INTERNAL_PERMIT_ALL = {"/api/v1/test", "/api/v1/auth/login"};
    public static final String PASSWORD_CLAIM = "password_claim";

    // HEADER
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer";
}
