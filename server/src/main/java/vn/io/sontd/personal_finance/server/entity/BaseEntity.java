package vn.io.sontd.personal_finance.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import vn.io.sontd.personal_finance.server.constant.TableField;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    @Column(name = TableField.CREATED_AT, updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(name = TableField.CREATED_BY, updatable = false)
    private LocalDateTime createdBy;

    @LastModifiedDate
    @Column(name = TableField.UPDATED_AT)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(name = TableField.UPDATED_BY)
    private LocalDateTime updatedBy;
}
