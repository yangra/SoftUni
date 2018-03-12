package chainblock;

import com.google.common.collect.TreeMultiset;

import java.util.*;
import java.util.stream.Collectors;

public class Chainblock implements IChainblock {

    Map<Integer, Transaction> byInput;
    TreeMultiset<Transaction> byAmount;
    Map<TransactionStatus, TreeMap<Double, List<Transaction>>> byStatus;
    Map<String, TreeMap<Double, TreeSet<Transaction>>> byReceiver;
    Map<String, TreeMap<Double, List<Transaction>>> bySender;


    public Chainblock() {
        this.byInput = new LinkedHashMap<>();
        this.byStatus = new HashMap<>();
        this.bySender = new HashMap<>();
        this.byReceiver = new HashMap<>();
        this.byAmount = TreeMultiset.create((t1, t2) -> {
            if (t1.getAmount() != t2.getAmount()) {
              return   Double.compare(t2.getAmount(), t1.getAmount());
            }
            return Integer.compare(t1.getId(),t2.getId());
        });
    }

    @Override
    public int getCount() {
        return this.byInput.size();
    }

    @Override
    public void add(Transaction tx) {
        this.byInput.put(tx.getId(), tx);

        this.byStatus.putIfAbsent(tx.getStatus(), new TreeMap<>((k1, k2) -> Double.compare(k2, k1)));
        this.byStatus.get(tx.getStatus()).putIfAbsent(tx.getAmount(), new ArrayList<>());
        this.byStatus.get(tx.getStatus()).get(tx.getAmount()).add(tx);

        this.bySender.putIfAbsent(tx.getSender(), new TreeMap<>((k1, k2) -> Double.compare(k2, k1)));
        this.bySender.get(tx.getSender()).putIfAbsent(tx.getAmount(), new ArrayList<>());
        this.bySender.get(tx.getSender()).get(tx.getAmount()).add(tx);


        this.byReceiver.putIfAbsent(tx.getReceiver(), new TreeMap<>((k1, k2) -> Double.compare(k2, k1)));
        this.byReceiver.get(tx.getReceiver()).putIfAbsent(tx.getAmount(), new TreeSet());
        this.byReceiver.get(tx.getReceiver()).get(tx.getAmount()).add(tx);

        this.byAmount.add(tx);
    }

    @Override
    public boolean contains(Transaction tx) {
        return this.byInput.containsKey(tx.getId());
    }

    @Override
    public boolean contains(int id) {
        return this.byInput.containsKey(id);
    }

    @Override
    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!this.byInput.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        Transaction forChange = this.byInput.get(id);
        this.byStatus.get(forChange.getStatus()).get(forChange.getAmount());
        forChange.setStatus(newStatus);

        this.byStatus.putIfAbsent(newStatus, new TreeMap<>((k1, k2) -> Double.compare(k2, k1)));
        this.byStatus.get(newStatus).putIfAbsent(forChange.getAmount(), new ArrayList<>());
        this.byStatus.get(newStatus).get(forChange.getAmount()).add(forChange);
    }

    @Override
    public void removeTransactionById(int id) {
        if (!this.byInput.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        Transaction tx = this.byInput.remove(id);
        this.byReceiver.get(tx.getReceiver()).get(tx.getAmount()).remove(tx);
        if (this.byReceiver.get(tx.getReceiver()).get(tx.getAmount()).size() == 0) {
            this.byReceiver.get(tx.getReceiver()).remove(tx.getAmount());
        }
        if (this.byReceiver.get(tx.getReceiver()).size() == 0) {
            this.byReceiver.remove(tx.getReceiver());
        }
        this.bySender.get(tx.getSender()).get(tx.getAmount()).remove(tx);
        if (this.bySender.get(tx.getSender()).get(tx.getAmount()).size() == 0) {
            this.bySender.get(tx.getSender()).remove(tx.getAmount());
        }
        if (this.bySender.get(tx.getSender()).size() == 0) {
            this.bySender.remove(tx.getSender());
        }
        this.byStatus.get(tx.getStatus()).get(tx.getAmount()).remove(tx);
        if (this.byStatus.get(tx.getStatus()).get(tx.getAmount()).size() == 0) {
            this.byStatus.get(tx.getStatus()).remove(tx.getAmount());
        }
        if (this.byStatus.get(tx.getStatus()).size() == 0) {
            this.byStatus.remove(tx.getStatus());
        }
        this.byAmount.remove(tx);
    }

    @Override
    public Transaction getById(int id) {
        if (!this.byInput.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        return this.byInput.get(id);
    }

    @Override
    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        if (!this.byStatus.containsKey(status)) {
            throw new IllegalArgumentException();
        }
        List<Transaction> result = new ArrayList<>();
        this.byStatus.get(status).values().forEach(result::addAll);
        return result;
    }

    @Override
    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        if (!this.byStatus.containsKey(status)) {
            throw new IllegalArgumentException();
        }
        List<Transaction> result = new ArrayList<>();
        this.byStatus.get(status).values().forEach(result::addAll);
        return result.stream().map(Transaction::getSender).collect(Collectors.toList());
    }

    @Override
    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        if (!this.byStatus.containsKey(status)) {
            throw new IllegalArgumentException();
        }
        List<Transaction> result = new ArrayList<>();
        this.byStatus.get(status).values().forEach(result::addAll);
        return result.stream().map(Transaction::getReceiver).collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.byAmount;
    }

    @Override
    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        if (!this.bySender.containsKey(sender)) {
            throw new IllegalArgumentException();
        }
        List<Transaction> result = new ArrayList<>();
        this.bySender.get(sender).values().forEach(result::addAll);
        return result;
    }

    @Override
    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        if (!this.byReceiver.containsKey(receiver)) {
            throw new IllegalArgumentException();
        }
        List<Transaction> result = new ArrayList<>();
        this.byReceiver.get(receiver).values().forEach(result::addAll);
        return result;
    }

    @Override
    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        if (!this.byStatus.containsKey(status)) {
            return new ArrayList<>();
        }
        List<Double> amounts = this.byStatus.get(status).keySet().stream().filter(k -> k <= amount).collect(Collectors.toList());
        List<Transaction> result = new ArrayList<>();
        for (Double filtered : amounts) {
            result.addAll(this.byStatus.get(status).get(filtered));
        }
        return result;
    }


    @Override
    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        if (!this.bySender.containsKey(sender)) {
            throw new IllegalArgumentException();
        }

        List<Double> amounts = this.bySender.get(sender).keySet().stream().filter(k -> k > amount).collect(Collectors.toList());
        List<Transaction> result = new ArrayList<>();
        for (Double filtered : amounts) {
            result.addAll(this.bySender.get(sender).get(filtered));
        }
        return result;
    }

    @Override
    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        if (!this.byReceiver.containsKey(receiver)) {
            throw new IllegalArgumentException();
        }
        List<Double> amounts = this.byReceiver.get(receiver).keySet().stream().filter(k -> k >= lo && k < hi).collect(Collectors.toList());
        List<Transaction> result = new ArrayList<>();
        for (Double filtered : amounts) {
            result.addAll(this.byReceiver.get(receiver).get(filtered));
        }
        return result;
    }

    @Override
    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> result = this.byInput.values().stream().filter(t -> t.getAmount() >= lo && t.getAmount() <= hi).collect(Collectors.toList());
        return result;
    }

    @Override
    public Iterator<Transaction> iterator() {
        return this.byInput.values().iterator();
    }
}
