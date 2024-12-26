import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSRP {
    private static final String RESOURCES = "src/";

    public static void main(String[] args) throws Exception {
        final BankStatementCSVParser csvParser = new BankStatementCSVParser();
        final Path path = Paths.get(RESOURCES + args[0]);

        final List<String> lines = Files.readAllLines(path); //파일을 읽어 각 행을 리스트로 반환
        final List<BankTransaction> bankTransactions = csvParser.parseLinesFrom(lines);
        System.out.printf("The Total for all transactions is " + calculateTotalAount(bankTransactions));
        System.out.println();
        System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));
    }

    public static double calculateTotalAount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }
    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }

}