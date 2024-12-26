import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class BankStatementCSVParser implements BankStateParser{ //파서 메서드
    private static final DateTimeFormatter DATE_PATTEN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public BankTransaction parseFrom(final String line){//행을 콤마로 구분
        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTEN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);

    }// 구분한 데이터 리스트에 넣음
    public List<BankTransaction> parseLinesFrom(final List<String> lines){
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (final String line : lines) {
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }
}
