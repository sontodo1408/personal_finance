package vn.io.sontd.personal_finance.server.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseRoot {
    private Integer code;
    private String msg;
    private ResponseBody payload;
}
