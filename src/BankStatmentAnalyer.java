import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatmentAnalyer {
    private static final String RESOURSE= "src/";

    public void analyze(final String filename,final BankStateParser bankStateParser)
        throws IOException {
        final Path path = Paths.get(filename);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStateParser.parseLinesFrom(lines);
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
