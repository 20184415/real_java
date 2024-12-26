import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class BankStatementAnalyzerSimple {

    private static final String RESOURCES = "src/";
    private static final BankStatementCSVParser parser = new BankStatementCSVParser();


    public static void main(final String[] args) throws Exception {
        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + fileName); //데이터 받음
        final List<String> lines = Files.readAllLines(path); //전체데이터를 한 행씩 읽음

        final List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines); //정리된 데이터
        final BankStateProcessor bankStateProcessor = new BankStateProcessor(bankTransactions);

        collectSummary(bankStateProcessor);
    }
        private static void collectSummary (BankStateProcessor bankStateProcessor){
            System.out.println("The total for all transactions is " + bankStateProcessor.calculateTotalAmount());
            System.out.println("The total for all transactions in January is " + bankStateProcessor.calculateTotalInMonth(Month.JANUARY));
            System.out.println("The total for all transactions in February is " + bankStateProcessor.calculateTotalInMonth(Month.FEBRUARY));
            System.out.println("The total salary received is " + bankStateProcessor.calculateTotalForCategory("Tesco"));
        }
    }