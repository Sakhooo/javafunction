package kz.stream;

import kz.model.trader.Transaction;
import kz.util.TaskUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionsTask {
    public static void main(String[] args) {
        List<Transaction> transactions = TaskUtil.getTransactions();
        List<Transaction> collect = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        List<String> distinctCity = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        List<Transaction> cambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .sorted((t1, t2) -> t1.getTrader().getName().compareToIgnoreCase(t2.getTrader().getName()))
                .collect(Collectors.toList());
        Stream<String> sortedName = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted(String::compareToIgnoreCase);

        Optional<Transaction> milan = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Milan"))
                .findAny();

        Optional<Integer> cambridge1 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        Optional<Integer> min = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);



    }
}
