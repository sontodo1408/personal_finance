package vn.io.sontd.personal_finance.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import vn.io.sontd.personal_finance.server.constant.TableField;

import java.time.LocalDate;

@Entity
@Table(name = TableField.TBL_USER_SETTINGS)
@AllArgsConstructor
@NoArgsConstructor
public class UserSettingEntity {
    @Id
    @Column(name = TableField.USER_ID)
    private Integer userId;

    @Column(name = TableField.DASHBOARD_POSITION)
    private String dashboardPosition;

    @Column(name = TableField.MONTH_START_AT)
    private LocalDate monthStartAt;
}
