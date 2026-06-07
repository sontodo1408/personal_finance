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
@Table(name = TableField.TBL_USERS)
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity {
    @Id
    @Column(name = TableField.ID)
    private Integer id;

    @Column(name = TableField.FULL_NAME)
    private String fullName;

    @Column(name = TableField.PHONE_NUMBER)
    private String phoneNumber;

    @Column(name = TableField.BIRTHDAY)
    private LocalDate birthday;

    @Column(name = TableField.USERNAME)
    private String username;

    @Column(name = TableField.PASSWORD)
    private String password;

    @Column(name = TableField.STATUS)
    private Integer status;

    @Column(name = TableField.ROLE)
    private String role;
}
