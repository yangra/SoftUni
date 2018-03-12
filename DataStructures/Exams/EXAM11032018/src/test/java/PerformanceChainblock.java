import chainblock.Chainblock;
import chainblock.IChainblock;
import chainblock.Transaction;
import chainblock.TransactionStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PerformanceChainblock {

    //Add (Show Visa that you are not to be reckoned with
    @Test
    public void Add_100000_Transactions_Should_WorkFast()
    {

        IChainblock cb = new Chainblock();
        int count = 100000;
        TransactionStatus[] statuses = new TransactionStatus[]
                {
                        TransactionStatus.Aborted,
                        TransactionStatus.Failed,
                        TransactionStatus.Successfull,
                        TransactionStatus.Unauthorized
                };
        Random rand = new Random();
        long start = System.currentTimeMillis();
        for(int i = 0; i < count; i++)
        {
            //int status = rand.nextInt(0, 4);
            cb.add(new Transaction(i, TransactionStatus.Successfull,
                    String.valueOf(i), String.valueOf(i), i));
        }

        long end = System.currentTimeMillis();
        Assert.assertEquals(count, cb.getCount());
        Assert.assertTrue(end - start < 400);
    }


    //Contains
    @Test
    public void Contains_100000_ShouldWorkFast()
    {
        IChainblock cb = new Chainblock();
        int count = 100000;
        List<Transaction> txs = new ArrayList<Transaction>();
        TransactionStatus[] statuses = new TransactionStatus[]
                {
                        TransactionStatus.Aborted,
                        TransactionStatus.Failed,
                        TransactionStatus.Successfull,
                        TransactionStatus.Unauthorized
                };
        Random rand = new Random();

        for (int i = 0; i < count; i++)
        {
            int status = rand.nextInt(4);
            Transaction tx = new Transaction(i, statuses[status],
                    String.valueOf(i), String.valueOf(i), i);
            cb.add(tx);
            txs.add(tx);
        }
        Assert.assertEquals(count, cb.getCount());

        long start = System.currentTimeMillis();

        for (Transaction tx : txs)
        {
            Assert.assertEquals(true, cb.contains(tx));
        }

        long end = System.currentTimeMillis();

        Assert.assertTrue(end - start < 200);
    }

    //ContainsById
    @Test
    public void ContainsById_100000_ShouldWorkFast()
    {
        IChainblock cb = new Chainblock();
        int count = 100000;
        List<Transaction> txs = new ArrayList<Transaction>();
        TransactionStatus[] statuses = new TransactionStatus[]
                {
                        TransactionStatus.Aborted,
                        TransactionStatus.Failed,
                        TransactionStatus.Successfull,
                        TransactionStatus.Unauthorized
                };
        Random rand = new Random();
        for (int i = 0; i < count; i++)
        {
            int status = rand.nextInt(4);
            Transaction tx = new Transaction(i, statuses[status],
                    String.valueOf(i), String.valueOf(i), i);
            cb.add(tx);
            txs.add(tx);
        }

        Assert.assertEquals(count, cb.getCount());

        long start = System.currentTimeMillis();

        for (Transaction tx : txs)
        {
            Assert.assertEquals(true, cb.contains(tx.getId()));
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;

        Assert.assertTrue(l1 < 200);
    }

    //ChangeTransactionStatus
    @Test
    public void ChangeTransactionStatus_ShouldWorkFast()
    {
        IChainblock cb = new Chainblock();
        TransactionStatus[] statuses = new TransactionStatus[]
                {
                        TransactionStatus.Aborted,
                        TransactionStatus.Failed,
                        TransactionStatus.Successfull,
                        TransactionStatus.Unauthorized
                };
        Random rand = new Random();
        List<Transaction> txs = new ArrayList<Transaction>();
        for (int i = 0; i < 100000; i++)
        {
            int status = rand.nextInt(4);
            Transaction tx = new Transaction(i, statuses[status],
                    String.valueOf(i), String.valueOf(i), i);
            cb.add(tx);
            txs.add(tx);
        }

        int count = cb.getCount();
        Assert.assertEquals(100000, count);

        long start = System.currentTimeMillis();

        for (Transaction tx : txs)
        {
            Assert.assertEquals(true, cb.contains(tx.getId()));
            int status = rand.nextInt( 4);
            cb.changeTransactionStatus(tx.getId(), statuses[status]);
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;
        Assert.assertTrue(l1 < 350);
    }

    //RemoveById
    @Test
    public void RemoveById_ShoudlWorkFast()
    {

        IChainblock cb = new Chainblock();
        List<Transaction> txs = new ArrayList<Transaction>();
        Random rand = new Random();
        for (int i = 0; i < 100000; i++)
        {
            int amount = rand.nextInt(60000);
            Transaction tx = new Transaction(i, TransactionStatus.Successfull,
                    String.valueOf(i), String.valueOf(i), amount);
            cb.add(tx);
            txs.add(tx);
        }

        int count = cb.getCount();
        Assert.assertEquals(100000, count);

        long start = System.currentTimeMillis();

        for (Transaction tx : txs)
        {
            cb.removeTransactionById(tx.getId());
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;
        Assert.assertTrue(l1 < 200);
    }

    //GetById
    @Test
    public void GetById_ShouldWorkFast()
    {

        IChainblock cb = new Chainblock();
        TransactionStatus[] statuses = new TransactionStatus[]
                {
                        TransactionStatus.Aborted,
                        TransactionStatus.Failed,
                        TransactionStatus.Successfull,
                        TransactionStatus.Unauthorized
                };
        Random rand = new Random();
        List<Transaction> txs = new ArrayList<Transaction>();
        for (int i = 0; i < 100000; i++)
        {
            int status = rand.nextInt(4);
            Transaction tx = new Transaction(i, statuses[status],
                    String.valueOf(i), String.valueOf(i), i);
            cb.add(tx);
            txs.add(tx);
        }

        int count = cb.getCount();
        Assert.assertEquals(100000, count);

        long start = System.currentTimeMillis();

        for (Transaction tx : txs)
        {
            Assert.assertSame(tx, cb.getById(tx.getId()));
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;

        Assert.assertTrue(l1 < 150);
    }

    //GetByTxStatus
    @Test
    public void GetByTransactionStatus_ShouldWorkFast()
    {
        IChainblock cb = new Chainblock();
        List<Transaction> txs = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 100000; i++)
        {
            int amount = rand.nextInt(50000);
            Transaction tx = new Transaction(i, TransactionStatus.Successfull,
                    String.valueOf(i), String.valueOf(i), amount);

            cb.add(tx);
            txs.add(tx);
        }

        int count = cb.getCount();
        Assert.assertEquals(100000, count);
        long start = System.currentTimeMillis();

        Iterable<Transaction> byStatus = cb.getByTransactionStatus(
                TransactionStatus.Successfull);
        int c = 0;

        for (Transaction employee : byStatus)
        {
            c++;
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;
        Assert.assertTrue(l1 < 150);
        Assert.assertEquals(100000, c);
    }

    //GetAllOrderedByAmountDescendingThenById
    @Test
    public void GetOrderedByAmountDescendingThenById_ShouldWorkFast()
    {
        IChainblock cb = new Chainblock();
        List<Transaction> txs = new ArrayList<Transaction>();
        for (int i = 0; i < 100000; i++)
        {
            Transaction tx = new Transaction(i, TransactionStatus.Successfull,
                    String.valueOf(i), String.valueOf(i), i);
            cb.add(tx);
            txs.add(tx);
        }

        int count = cb.getCount();
        Assert.assertEquals(100000, count);
        long start = System.currentTimeMillis();

        Iterable<Transaction> all = cb.getAllOrderedByAmountDescendingThenById();
        int c = 0;
        for (Transaction tx : all)
        {
            c++;
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;

        Assert.assertTrue(l1 < 150);
        Assert.assertEquals(100000, c);
    }

    //GetBySenderOrderedByAmountDescending
    @Test
    public void GetBySenderOrderedByAmountDescending_ShouldWorkFast()
    {
        IChainblock cb = new Chainblock();
        List<Transaction> txs = new ArrayList<Transaction>();
        for (int i = 0; i < 100000; i++)
        {
            Transaction tx = new Transaction(i, TransactionStatus.Successfull,
                    "sender", String.valueOf(i), i);
            cb.add(tx);
            txs.add(tx);
        }

        int count = cb.getCount();
        txs = txs.stream().sorted((x,y) -> Double.compare(y.getAmount(),x.getAmount())).collect(Collectors.toList());
        Assert.assertEquals(100000, count);
        long start = System.currentTimeMillis();

        Iterable<Transaction> all = cb.getBySenderOrderedByAmountDescending("sender");
        int c = 0;
        for (Transaction tx : all)
        {
            Assert.assertSame(tx, txs.get(c));
            c++;
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;

        Assert.assertTrue(l1 < 200);
        Assert.assertEquals(100000, c);
    }

    //GetByReceiverOrderedByAmountThenById
    @Test
    public void GetByReceiverOrderedByAmountThenById_ShouldWorkFast_1()
    {
        IChainblock cb = new Chainblock();
        List<Transaction> txs = new ArrayList<Transaction>();
        for (int i = 0; i < 100000; i++)
        {
            Transaction tx = new Transaction(i, TransactionStatus.Successfull,
                    String.valueOf(i), "to", i);
            cb.add(tx);
            txs.add(tx);
        }

        int count = cb.getCount();
        txs = txs.stream().sorted((x,y) -> {
            int compare = Double.compare(y.getAmount(),x.getAmount());
            if(compare == 0){
                return Integer.compare(x.getId(), y.getId());
            }
            return compare;
        }).collect(Collectors.toList());
        Assert.assertEquals(100000, count);
        long start = System.currentTimeMillis();

        Iterable<Transaction> all = cb.getByReceiverOrderedByAmountThenById("to");
        int c = 0;
        for (Transaction tx : all)
        {
            Assert.assertSame(tx, txs.get(c));
            c++;
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;

        Assert.assertTrue(l1 < 200);
        Assert.assertEquals(100000, c);
    }

    //GetByTransactionStatusAndMaximumAmount
    @Test
    public void GetByTransactionStatusAndMaximumAmount_ShouldWorkFast_1()
    {
        IChainblock cb = new Chainblock();
        List<Transaction> txs = new ArrayList<Transaction>();
        Random rand = new Random();
        for (int i = 0; i < 100000; i++)
        {
            int amount = rand.nextInt(1000);
            Transaction tx = new Transaction(i, TransactionStatus.Successfull,
                    String.valueOf(i), String.valueOf(i), amount);
            cb.add(tx);
            if (amount <= 500) txs.add(tx);
        }
        txs = txs.stream().sorted((x,y) -> Double.compare(y.getAmount(),x.getAmount())).collect(Collectors.toList());
        int count = cb.getCount();
        Assert.assertEquals(100000, count);
        long start = System.currentTimeMillis();

        Iterable<Transaction> all = cb.getByTransactionStatusAndMaximumAmount(
                TransactionStatus.Successfull, 500);
        int c = 0;
        for (Transaction tx : all)
        {
            Assert.assertSame(tx, txs.get(c));
            c++;
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;

        Assert.assertTrue(l1 < 150);
        Assert.assertEquals(txs.size(), c);
    }

    //GetByReceiverOrderedByAmountThenById
    @Test
    public void GetByReceiverOrderedByAmountThenById_ShouldWorkFast_2()
    {
        IChainblock cb = new Chainblock();
        List<Transaction> txs = new ArrayList<Transaction>();
        for (int i = 0; i < 100000; i++)
        {
            Transaction tx = new Transaction(i, TransactionStatus.Successfull,
                    String.valueOf(i), "to", i);
            cb.add(tx);
            txs.add(tx);
        }

        int count = cb.getCount();
        txs = txs.stream().sorted((x,y) -> {
            int compare = Double.compare(y.getAmount(),x.getAmount());
            if(compare == 0){
                return Integer.compare(x.getId(), y.getId());
            }
            return compare;
        }).collect(Collectors.toList());
        Assert.assertEquals(100000, count);
        long start = System.currentTimeMillis();

        Iterable<Transaction> all = cb.getByReceiverOrderedByAmountThenById("to");
        int c = 0;
        for (Transaction tx : all)
        {
            Assert.assertSame(tx, txs.get(c));
            c++;
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;

        Assert.assertTrue(l1 < 200);
        Assert.assertEquals(100000, c);
    }


    //GetByTransactionStatusAndMaximumAmount
    @Test
    public void GetByTransactionStatusAndMaximumAmount_ShouldWorkFast_2()
    {
        IChainblock cb = new Chainblock();
        List<Transaction> txs = new ArrayList<Transaction>();
        Random rand = new Random();
        for (int i = 0; i < 100000; i++)
        {
            int amount = rand.nextInt(1000);
            Transaction tx = new Transaction(i, TransactionStatus.Successfull,
                    String.valueOf(i), String.valueOf(i), amount);
            cb.add(tx);
            if (amount <= 500) txs.add(tx);
        }
        txs = txs.stream().sorted((x,y) -> Double.compare(y.getAmount(),x.getAmount())).collect(Collectors.toList());
        int count = cb.getCount();
        Assert.assertEquals(100000, count);
        long start = System.currentTimeMillis();

        Iterable<Transaction> all = cb.getByTransactionStatusAndMaximumAmount(
                TransactionStatus.Successfull, 500);
        int c = 0;
        for (Transaction tx : all)
        {
            Assert.assertSame(tx, txs.get(c));
            c++;
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;

        Assert.assertTrue(l1 < 150);
        Assert.assertEquals(txs.size(), c);
    }


    //GetBySenderAndMinimumAmountDescending
    @Test
    public void GetBySenderAndMinimumAmountDescending_ShouldWorkFast()
    {
        IChainblock cb = new Chainblock();
        List<Transaction> txs = new ArrayList<Transaction>();
        Random rand = new Random();
        for (int i = 0; i < 100000; i++)
        {
            int amount = rand.nextInt(1000);
            Transaction tx = new Transaction(i, TransactionStatus.Successfull,
                    "sender", String.valueOf(i), amount);
            cb.add(tx);
            if(amount > 500) txs.add(tx);
        }
        txs = txs.stream().sorted((x,y) -> Double.compare(y.getAmount(),x.getAmount())).collect(Collectors.toList());
        int count = cb.getCount();
        Assert.assertEquals(100000, count);
        long start = System.currentTimeMillis();

        Iterable<Transaction> all = cb.getBySenderAndMinimumAmountDescending(
                "sender", 500);
        int c = 0;
        for (Transaction tx : all)
        {
            Assert.assertSame(tx, txs.get(c));
            c++;
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;

        Assert.assertTrue(l1 < 150);
        Assert.assertEquals(txs.size(), c);
    }

    //GetByReceiverAndAmountRange
    @Test
    public void GetByReceiverAndAmountRange()
    {
        IChainblock cb = new Chainblock();
        List<Transaction> txs = new ArrayList<Transaction>();
        Random rand = new Random();
        for (int i = 0; i < 100000; i++)
        {
            int amount = rand.nextInt(1000);
            Transaction tx = new Transaction(i, TransactionStatus.Successfull,
                    "sender", "from", amount);
            cb.add(tx);
            if (amount >= 200 && amount < 600) txs.add(tx);
        }
        txs = txs.stream().sorted((x,y) -> {
            int compare = Double.compare(y.getAmount(),x.getAmount());
            if(compare == 0){
                return Integer.compare(x.getId(), y.getId());
            }
            return compare;
        }).collect(Collectors.toList());
        int count = cb.getCount();
        Assert.assertEquals(100000, count);
        long start = System.currentTimeMillis();

        Iterable<Transaction> all = cb.getByReceiverAndAmountRange(
                "from", 200, 600);
        int c = 0;
        for (Transaction tx : all)
        {
            Assert.assertSame(tx, txs.get(c));
            c++;
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;

        Assert.assertTrue(l1 < 150);
        Assert.assertEquals(txs.size(), c);
    }


    @Test
    public void GetAllInAmountRange()
    {
        IChainblock cb = new Chainblock();
        List<Transaction> txs = new ArrayList<Transaction>();
        Random rand = new Random();
        for (int i = 0; i < 100000; i++)
        {
            int amount = rand.nextInt(1000);
            Transaction tx = new Transaction(i, TransactionStatus.Successfull,
                    "sender", "from", amount);
            cb.add(tx);
            if (amount >= 200 && amount <= 600) txs.add(tx);
        }
        int count = cb.getCount();
        Assert.assertEquals(100000, count);
        long start = System.currentTimeMillis();

        Iterable<Transaction> all = cb.getAllInAmountRange(200, 600);
        int c = 0;
        for (Transaction tx : all)
        {
            Assert.assertSame(tx, txs.get(c));
            c++;
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;

        Assert.assertTrue(l1 < 150);
        Assert.assertEquals(txs.size(), c);
    }


    //GetAllReceiversWithTransactionStatus
    @Test
    public void GetAllReceiversWithTransactionStatus_ShouldWorkFast()
    {
        IChainblock cb = new Chainblock();
        List<Transaction> txs = new ArrayList<Transaction>();
        TransactionStatus[] statuses = new TransactionStatus[]
                {
                        TransactionStatus.Aborted,
                        TransactionStatus.Failed,
                        TransactionStatus.Successfull,
                        TransactionStatus.Unauthorized
                };
        Random rand = new Random();
        for (int i = 0; i < 100000; i++)
        {
            int status = rand.nextInt(4);
            TransactionStatus TS = statuses[status];
            Transaction tx = new Transaction(i, TS,
                    String.valueOf(i), String.valueOf(i), i);
            cb.add(tx);
            if (status == 2) txs.add(tx);
        }
        Collections.reverse(txs);
        int count = cb.getCount();
        Assert.assertEquals(100000, count);
        long start = System.currentTimeMillis();

        Iterable<String> all = cb.getAllReceiversWithTransactionStatus(TransactionStatus.Successfull);
        int c = 0;
        for (String tx : all)
        {
            Assert.assertEquals(tx, txs.get(c).getReceiver());
            c++;
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;

        Assert.assertTrue(l1 < 150);
        Assert.assertEquals(txs.size(), c);
    }

    // GetAllSendersWithTransactionStatus
    @Test
    public void GetAllSendersWithTransactionStatus_ShouldWorkFast()
    {
        IChainblock cb = new Chainblock();
        List<Transaction> txs = new ArrayList<Transaction>();
        TransactionStatus[] statuses = new TransactionStatus[]
                {
                        TransactionStatus.Aborted,
                        TransactionStatus.Failed,
                        TransactionStatus.Successfull,
                        TransactionStatus.Unauthorized
                };
        Random rand = new Random();
        for (int i = 0; i < 100000; i++)
        {
            int status = rand.nextInt(4);
            TransactionStatus TS = statuses[status];
            Transaction tx = new Transaction(i, TS,
                    String.valueOf(i), String.valueOf(i), i);
            cb.add(tx);
            if(TS == TransactionStatus.Successfull) txs.add(tx);
        }
        Collections.reverse(txs);
        int count = cb.getCount();
        Assert.assertEquals(100000, count);
        long start = System.currentTimeMillis();

        Iterable<String> all = cb.getAllSendersWithTransactionStatus(TransactionStatus.Successfull);
        int c = 0;
        for (String tx : all) {
            Assert.assertEquals(tx, txs.get(c).getSender());
            c++;
        }

        long end = System.currentTimeMillis();
        long l1 = end - start;

        Assert.assertTrue(l1 < 150);
        Assert.assertEquals(txs.size(), c);
    }

}
