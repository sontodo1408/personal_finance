package vn.io.sontd.personal_finance.server.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenInfoDTO {
    private String username;
    private String password;
}
