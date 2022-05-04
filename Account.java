import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
private int balance;
private Lock accessLock;
private Condition sufficientFunds;

// Construcutor to setup an Account with Locking System
public Account() {
balance = 0;
accessLock = new ReentrantLock();
sufficientFunds = accessLock.newCondition();
}

// Locking system for Handeling a deposit
public void deposit() throws InterruptedException{
int add = randTransaction.newNumber(true);
accessLock.lock();
try {
balance += add;
System.out.printf("Thread %s deposits $%-3d\t\t\t\t\t\t(+)Balence is $%-3d\n", Thread.currentThread().getName(), add, balance);
sufficientFunds.signalAll();
} finally {
accessLock.unlock();
}
}

// Locking system for Handeling a withdrawl
public void withdrawl() throws InterruptedException {
int sub = randTransaction.newNumber(false);
accessLock.lock();
try {
// If funds, perform transactios.
if (balance > sub) {
balance -= sub;
System.out.printf("\t\t\t\tThread %s withdrawls $%-3d\t(-)Balence is $%-3d\n", Thread.currentThread().getName(), sub, balance);   
}
  
// If insufficient funds, wait until deposit to try again
else {
while (balance < sub) {
System.out.printf("\t\t\t\tThread %s withdrawls $%-3d\t(******)WITHDRAWAL BLOCKED - INSUFFICIENT FUNDS\n", Thread.currentThread().getName(), sub);
sufficientFunds.await();
}
}

} catch (InterruptedException e) {
e.printStackTrace();
} finally {
accessLock.unlock();
}
}
}