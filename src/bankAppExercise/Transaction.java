package bankAppExercise;

import java.time.LocalDateTime;
import java.util.Random;

public enum Transaction {

    DEPOSIT, WITHDRAWAL, TRANSFER;

    private String payerName;
    private String payeeName;
    private double transactionAmount;
    private LocalDateTime date;
}


