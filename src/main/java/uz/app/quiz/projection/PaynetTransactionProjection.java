package uz.app.quiz.projection;

import java.sql.Timestamp;
import java.util.UUID;

public interface PaynetTransactionProjection {
    UUID getId();
    Long getAmount();
    Long getServiceId();
    Long getTransactionId();
    Timestamp getTransactionTime();
    Integer getClientId();
    UUID getOrderId();

    Integer getState();
}
