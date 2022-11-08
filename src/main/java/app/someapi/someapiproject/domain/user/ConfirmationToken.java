package app.someapi.someapiproject.domain.user;

import app.someapi.someapiproject.domain.BaseEntity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "confirmation_token")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmationToken extends BaseEntity {

    @Column
    private String userId;
    @Column
    private LocalDateTime expiredAt;
    @Column
    private String token;
}
