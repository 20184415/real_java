
import java.util.List;

public interface BankStateParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> Line);
}
