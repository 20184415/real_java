public class MainApplication {
    public static void main(String[] args) throws Exception {
        final BankStatmentAnalyer bankStatmentAnalyer = new BankStatmentAnalyer();
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        bankStatmentAnalyer.analyze("src/bank-data-simple.csv", bankStatementCSVParser);

    }
}
