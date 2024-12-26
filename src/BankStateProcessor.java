import java.time.Month;
import java.time.Year;
import java.util.List;

public class BankStateProcessor {
    private final List<BankTransaction> bankTransactions;
    public BankStateProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }
    public double calculateTotalAmount() {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
                total += bankTransaction.getAmount();

        }
        return total;
    }
    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth().equals(month)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
    public double calculateTotalForCategory(final String category) {
        double total = 0;

        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {

                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}
