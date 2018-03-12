import chainblock.Chainblock;
import chainblock.IChainblock;
import chainblock.Transaction;
import chainblock.TransactionStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CorrectnessChainblock {
    //addition
    @Test
    public void add_SingleElement_ShouldWorkCorrectly()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        //Act
        cb.add(tx);

        //Assert
        for (Transaction transaction : cb)
        {
            Assert.assertSame(transaction, tx);
        }
    }

    @Test
    public void add_SingleElement_ShouldIncreaseCountTo1()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        //Act
        cb.add(tx);

        //Assert
        for (Transaction transaction : cb)
        {
            Assert.assertSame(transaction, tx);
        }

        Assert.assertEquals(1, cb.getCount());
    }

    @Test
    public void add_MultipleElements_CB_ShouldContainThem()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5);
        //Act
        cb.add(tx1);
        cb.add(tx2);
        cb.add(tx3);
        //Assert
        Assert.assertTrue(cb.contains(tx1));
        Assert.assertTrue(cb.contains(tx2));
        Assert.assertTrue(cb.contains(tx3));
    }

    @Test
    public void add_MultipleElements_CB_ShouldContainThemById()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5);
        //Act
        cb.add(tx1);
        cb.add(tx2);
        cb.add(tx3);
        //Assert
        Assert.assertTrue(cb.contains(tx1.getId()));
        Assert.assertTrue(cb.contains(tx2.getId()));
        Assert.assertTrue(cb.contains(tx3.getId()));
    }

    //Contains
    @Test
    public void Contains_OnEmptyChainblock_ShouldReturnFalse()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        //Act
        //Assert
        Assert.assertFalse(cb.contains(5));
        Assert.assertFalse(cb.contains(new Transaction(3, TransactionStatus.Failed, "a", "b", 0.5)));
    }

    @Test
    public void Contains_OnExistingElement_ShouldReturnTrue()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5);
        //Act
        cb.add(tx1);
        cb.add(tx2);
        cb.add(tx3);
        //Assert
        Assert.assertTrue(cb.contains(5));
        Assert.assertFalse(cb.contains(3));
        Assert.assertTrue(cb.contains(tx2));
        Assert.assertFalse(cb.contains(new Transaction(0, TransactionStatus.Failed, "b", "b", 5)));
    }

    //Count
    @Test
    public void Count_Should_IncreaseOnMultiple_Elements()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5);
        //Act
        cb.add(tx1);
        cb.add(tx2);
        cb.add(tx3);
        //Assert
        Assert.assertEquals(3, cb.getCount());
    }

    @Test
    public void Count_Should_Be_0_On_EmptyCollection()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        //Act
        //Assert
        Assert.assertEquals(0, cb.getCount());
    }

    @Test
    public void Count_Should_RemainCorrect_AfterRemoving()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5);
        //Act
        cb.add(tx1);
        cb.add(tx2);
        cb.add(tx3);
        cb.removeTransactionById(tx1.getId());
        cb.removeTransactionById(tx3.getId());
        //Assert
        Assert.assertEquals(1, cb.getCount());
        Assert.assertNotSame(tx1, cb.getById(tx2.getId()));
    }

    //GetById
    @Test
    public void GetById_On_ExistingElement_ShouldWorkCorrectly()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5);
        //Act
        cb.add(tx1);
        cb.add(tx2);
        cb.add(tx3);
        //Assert
        Assert.assertSame(tx1, cb.getById(5));
        Assert.assertNotSame(
                new Transaction(53, TransactionStatus.Failed, "a", "b", 5),
                cb.getById(7)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void GetById_On_NonExistingElement_ShouldThrow()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5);
        //Act
        cb.add(tx1);
        cb.add(tx2);
        cb.add(tx3);
        cb.removeTransactionById(5);
        //Assert

        cb.getById(5);

    }

    @Test
    public void GetById_On_Empty_Chainblock_ShouldThrow()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        //Act
        //Assert
        boolean throwed = false;
        try{
            cb.getById(5);
        }catch(IllegalArgumentException ex){
            throwed = true;
        }
        Assert.assertTrue(throwed);
    }

    //ChangeTxStatus
    @Test
    public void ChangeTransactionStatus_ShouldWorkCorrectly_On_ExistingTX()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5);
        //Act
        cb.add(tx1);
        cb.add(tx2);
        cb.add(tx3);
        cb.changeTransactionStatus(5, TransactionStatus.Aborted);
        //Assert
        Assert.assertEquals(TransactionStatus.Aborted, tx1.getStatus());
        Assert.assertEquals(3, cb.getCount());
    }

    @Test
    public void ChangeTransactionStatus_OnMultipleTransactions_ShouldWorkCorrectly()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5);
        //Act
        cb.add(tx1);
        cb.add(tx2);
        cb.add(tx3);
        cb.changeTransactionStatus(7, TransactionStatus.Unauthorized);
        cb.changeTransactionStatus(5, TransactionStatus.Aborted);
        cb.changeTransactionStatus(6, TransactionStatus.Successfull);
        //Assert
        Assert.assertEquals(3, cb.getCount());
        Assert.assertEquals(tx1.getStatus(), TransactionStatus.Aborted);
        Assert.assertEquals(tx3.getStatus(), TransactionStatus.Unauthorized);
        Assert.assertEquals(tx2.getStatus(), TransactionStatus.Successfull);
    }

    @Test
    public void GetAllOrderedByAmountDescendingThenById_ShouldReturnEmpty_OnEmptyCB()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        //Act
        //Assert
        List<Transaction> result = new ArrayList<>();
        Iterable<Transaction> res = cb.getAllOrderedByAmountDescendingThenById();
        for(Transaction tx : res){
            result.add(tx);
        }
        Transaction[] actual = new Transaction[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertEquals(new Transaction[0], actual);
    }

    @Test
    public void GetAllOrderedByAmountDescendingThenById_ShouldWorkCorrectlyAfterRemove()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Successfull, "joro", "pesho", 7.8);
        Transaction[] expected = new Transaction[]
                {
                        tx5,tx3,tx1
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        ArrayList<Transaction> result = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getAllOrderedByAmountDescendingThenById();
        for(Transaction tx : res){
            result.add(tx);
        }
        Assert.assertEquals(5, result.size());
        cb.removeTransactionById(tx4.getId());
        cb.removeTransactionById(tx2.getId());

        result = new ArrayList<Transaction>();
        res = cb.getAllOrderedByAmountDescendingThenById();
        for(Transaction tx : res){
            result.add(tx);
        }
        Transaction[] actual = new Transaction[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        //Assert
        Assert.assertArrayEquals(expected, actual);
    }

    //GetAllOrderedByAmountDescendingThenById
    @Test
    public void GetAllOrderedByAmountDescendingThenById_ShouldWorkCorrectly()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Successfull, "joro", "pesho", 7.8);
        Transaction[] expected = new Transaction[]
                {
                        tx4,tx5,tx2,tx3,tx1
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getAllOrderedByAmountDescendingThenById();
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        //Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void ChangeTransactionStatus_On_NonExistingTranasction_ShouldThrow()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        //Act
        //Assert
        boolean threw = false;
        try{
            cb.changeTransactionStatus(6, TransactionStatus.Failed);
        }catch(IllegalArgumentException ex){
            threw = true;
        }
        Assert.assertTrue(threw);
    }

    //Enumerator
    @Test
    public void CB_ShouldBeEnumeratedIn_InsertionOrder()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction[] expected = new Transaction[]
                {
                        tx1,tx3,tx2
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        for(Transaction tx : cb){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        //Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void CB_ShouldReturn_TransactionsInCorrectOrder_AfterDelete()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction[] expected = new Transaction[]
                {
                        tx2
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.removeTransactionById(5);
        cb.removeTransactionById(7);
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        for(Transaction tx : cb){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        //Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void GetByTransactionStatusAndMaximumAmount_ShouldReturnEmptyCollection()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "valq", "pesho", 17.8);
        //Act
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getByTransactionStatusAndMaximumAmount(TransactionStatus.Unauthorized,5);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(new Transaction[0], actual);
        cb = new Chainblock();
        list = new ArrayList<Transaction>();
        res = cb.getByTransactionStatusAndMaximumAmount(TransactionStatus.Unauthorized,1);
        for(Transaction tx : res){
            list.add(tx);
        }
        actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(new Transaction[0], actual);
    }

    @Test
    public void GetByTransactionStatusAndMaximumAmount_ShouldWorkCorrectly_AfterRemove()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "valq", "pesho", 17.8);
        Transaction[] expected = new Transaction[]
                {
                        tx2
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        cb.removeTransactionById(tx1.getId());
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getByTransactionStatusAndMaximumAmount(TransactionStatus.Successfull, 15.0);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void GetByTransactionStatusAndMaximumAmount_ShouldWorkCorrectly()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Successfull, "valq", "pesho", 17.8);
        Transaction[] expected = new Transaction[]
                {
                        tx3, tx4, tx1, tx2
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getByTransactionStatusAndMaximumAmount(TransactionStatus.Successfull, 17.0);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void GetByNonExistingTransactionStatus_ShouldThrow()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "valq", "pesho", 17.8);
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        cb.getByTransactionStatus(TransactionStatus.Unauthorized);
    }

    @Test
    public void GetByTransactionStatus_ShouldReturnCorrectResult()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Failed, "valq", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Successfull, "valq", "pesho", 17.8);
        Transaction[] expected = new Transaction[]
                {
                        tx5, tx3, tx1, tx2
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getByTransactionStatus(TransactionStatus.Successfull);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }


    //GetByTransactionStatus
    @Test
    public void GetByTransactionStatus_ShouldReturnCorrectResultAfterRemove()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "valq", "pesho", 17.8);
        Transaction[] expected = new Transaction[]{
                tx3, tx1, tx2
        };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        cb.removeTransactionById(8);
        cb.removeTransactionById(3);
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getByTransactionStatus(TransactionStatus.Successfull);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void GetBySenderOrderedByAmountDescending_ShouldOn_MissingSender()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "valq", "pesho", 17.8);
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        cb.removeTransactionById(8);
        cb.removeTransactionById(3);
        //Assert
        cb.getBySenderOrderedByAmountDescending("momo");

    }

    @Test
    public void GetBySenderOrderedByAmountDescending_ShouldWorkCorrectly_AfterRemove()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "valq", "pesho", 17.8);
        Transaction[] expected = new Transaction[]{
                tx3, tx1, tx2
        };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        cb.removeTransactionById(8);
        cb.removeTransactionById(3);
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getBySenderOrderedByAmountDescending("valq");
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    //GetBySenderOrderedByAmount
    @Test
    public void GetBySenderOrderedByAmountDescending_ShouldWorkCorrectly_OnExistingSender()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "valq", "pesho", 17.8);
        Transaction[] expected = new Transaction[]
                {
                        tx5, tx3, tx4, tx1, tx2
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getBySenderOrderedByAmountDescending("valq");
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void GetBySenderAndMinimumAmountDescending_ShouldThrowOnEmpty_CB()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        //Act
        //Assert
        boolean threw = false;
        cb.getBySenderAndMinimumAmountDescending("pesho",5);
        Assert.assertTrue(threw);
    }

    @Test
    public void GetBySenderAndMinimumAmountDescending_ShouldOrderAndPickCorrectly()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "valq", "pesho", 17.8);
        Transaction[] expected = new Transaction[]
                {
                        tx3
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        cb.removeTransactionById(8);
        cb.removeTransactionById(3);
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getBySenderAndMinimumAmountDescending("valq", 15.5);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    //GetAllInRange
    @Test
    public void GetInAmountRange_ShouldReturn_CorrectTransactionsByInsertionOrder()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 2);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Successfull, "joro", "pesho", 7.8);
        Transaction[] expected = new Transaction[]
                {
                        tx4,tx5
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getAllInAmountRange(7.8, 16);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        //Assert
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void GetAllInAmountRange_ShouldReturn_EmptyCollectionOnNonExistingRange()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 2);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Successfull, "joro", "pesho", 7.8);
        Transaction[] expected = new Transaction[0];
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getAllInAmountRange(7.7, 7.75);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        //Assert
        Assert.assertArrayEquals(expected, actual);
        cb.removeTransactionById(12);
        cb.removeTransactionById(15);
        list = new ArrayList<Transaction>();
        res = cb.getAllInAmountRange(7.8, 16);
        for(Transaction tx : res){
            list.add(tx);
        }
        actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    //GetBySenderWithTransactionStatus
    @Test
    public void GetAllSendersWithTransactionStatus_ShouldWorkCorrectly()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Aborted, "joro", "pesho", 5.5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Unauthorized, "boro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Unauthorized, "moro", "pesho", 7.8);
        String[] expected = new String[]
                {
                        "boro", "moro"
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        ArrayList<String> list = new ArrayList<String>();
        Iterable<String> res = cb.getAllSendersWithTransactionStatus(TransactionStatus.Unauthorized);
        for(String tx : res){
            list.add(tx);
        }
        String[] actual = new String[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        //Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void GetAllSendersWithTransactionStatus_OnNonExistantTxs_ShouldThrow()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Aborted, "joro", "pesho", 5.5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Aborted, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Failed, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Successfull, "joro", "pesho", 7.8);
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        cb.getAllSendersWithTransactionStatus(TransactionStatus.Unauthorized);

    }

    @Test(expected = IllegalArgumentException.class)
    public void GetAllSendersWithTransactionStatus_ShoudlThrowAfterRemove()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Failed, "joro", "pesho", 7.8);
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        cb.removeTransactionById(5);
        cb.removeTransactionById(7);
        cb.removeTransactionById(6);
        cb.removeTransactionById(12);
        cb.removeTransactionById(15);
        //Assert
        cb.getAllSendersWithTransactionStatus(TransactionStatus.Failed);
    }

    //GetBySenderWithTransactionStatus
    @Test
    public void GetAllReceiversWithTransactionStatus_ShouldWorkCorrectly()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Aborted, "joro", "pesho", 5.5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Unauthorized, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Unauthorized, "moro", "vesho", 7.8);
        String[] expected = new String[]{
                "pesho", "vesho"
        };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        ArrayList<String> list = new ArrayList<String>();
        Iterable<String> res = cb.getAllReceiversWithTransactionStatus(TransactionStatus.Unauthorized);
        for(String tx : res){
            list.add(tx);
        }
        String[] actual = new String[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        //Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void GetAllReceiversWithTransactionStatus_ShoudlThrowAfterRemove()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Failed, "joro", "pesho", 7.8);
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        cb.removeTransactionById(5);
        cb.removeTransactionById(7);
        cb.removeTransactionById(6);
        cb.removeTransactionById(12);
        cb.removeTransactionById(15);
        //Assert

        cb.getAllReceiversWithTransactionStatus(TransactionStatus.Failed);

    }

    @Test
    public void GetAllReceiversWithTransactionStatus_OnNonExistantTxs_ShouldThrow()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Aborted, "joro", "pesho", 5.5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Aborted, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Failed, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Successfull, "joro", "pesho", 7.8);
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        boolean threw = false;
        try{
            cb.getAllReceiversWithTransactionStatus(TransactionStatus.Unauthorized).iterator().next();
        }catch(IllegalArgumentException ex) {
            threw = true;
        }catch(NoSuchElementException e){
            threw = true;
        }
        Assert.assertTrue(threw);
    }

    //GetByReceiverAndAmountRange
    @Test
    public void GetByReceiverAndAmountRange_ShouldWorkCorrectly_On_CorrectRange()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Failed, "joro", "resho", 7.8);
        Transaction[] expected = new Transaction[]
                {
                        tx4, tx2, tx3, tx1
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getByReceiverAndAmountRange("pesho", 0, 20);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void GetByRceiver_ShouldReturnCorrectRange_CorrectlyOrdered()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "joro", "pesho", 17.8);
        Transaction[] expected = new Transaction[]
                {
                        tx5, tx4, tx3, tx2, tx1
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getByReceiverAndAmountRange("pesho", 0, 20);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void GetByReceiverAndAmountRange_ShouldThrow_AfterRemovingReceiver()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "mesho", 5.5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "vesho", 5.5);
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.removeTransactionById(5);
        //Assert
        boolean threw = false;
        try{
            cb.getByReceiverAndAmountRange("pesho", 0, 20).iterator().next();
        }catch(IllegalArgumentException ex){
            threw = true;
        }
        Assert.assertTrue(threw);
    }

    @Test
    public void GetByReceiverAndAmountRange_ShouldThrow_On_EmptyCB()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        //Act
        //Assert
        boolean threw = false;
        try{
            cb.getByReceiverAndAmountRange("pesho", 0, 20).iterator().next();
        }catch(IllegalArgumentException ex){
            threw = true;
        }
        Assert.assertTrue(threw);
    }

    //GetAllByReceiverOrderedByAmountDescendingThenById
    @Test
    public void GetByReceiver_ShouldWorkCorrectly()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "joro", "pesho", 17.8);
        Transaction[] expected = new Transaction[]
                {
                        tx5, tx4, tx3, tx2, tx1
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getByReceiverOrderedByAmountThenById("pesho");
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void GetByReceiver_On_NonExisting_Receiver_ShouldThrow()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "joro", "mesho", 1);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "joro", "kalin", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "joro", "barko", 17.8);

        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert

        cb.getByReceiverOrderedByAmountThenById("mecho");

    }

    @Test(expected = IllegalArgumentException.class)
    public void GetByReceiver_ShouldThrow_On_EmptyCB()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        //Act
        //Assert
        cb.getByReceiverOrderedByAmountThenById("pesho");
    }

    @Test
    public void GetBySenderAndMinimumAmountDescending_ShouldWorkCorrectly_OnExistingSender()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "valq", "pesho", 17.8);
        Transaction[] expected = new Transaction[]
                {
                        tx5, tx3, tx4
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getBySenderAndMinimumAmountDescending("valq",15.5);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void GetBySenderAndMinimumAmountDescending_ShouldThrow_OnMissingSender()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "valq", "pesho", 17.8);
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        cb.getBySenderAndMinimumAmountDescending("poncho", 15.5);

    }

    @Test
    public void GetAllInAmountRange_ShouldReturnEmptyEnumeration_On_EmptyCB()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        //Act
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getAllInAmountRange(7.7, 7.75);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = new Transaction[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            actual[i] = list.get(i);
        }
        //Assert
        Assert.assertArrayEquals(new Transaction[0], actual);
    }
}
