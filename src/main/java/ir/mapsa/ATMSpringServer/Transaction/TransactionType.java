package ir.mapsa.ATMSpringServer.Transaction;

public enum TransactionType {
    CREDIT(1),DEBIT(2);

    public final int code;

    private TransactionType(int code){
        this.code=code;
    }
}
