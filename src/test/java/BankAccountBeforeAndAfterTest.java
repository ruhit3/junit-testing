import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountBeforeAndAfterTest {

    static BankAccount bankAccount;

    @BeforeAll
    public void prepTest() {
        bankAccount = new BankAccount(500, 0);
        System.out.println("Balance: " + bankAccount.getBalance());
    }

    @Test
    public void testWithdraw() {
        bankAccount.withdraw(300);
        System.out.println("Balance after withdraw: " + bankAccount.getBalance());
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(500);
        System.out.println("Balance after deposit: " + bankAccount.getBalance());
        assertEquals(700, bankAccount.getBalance());
    }

    @AfterAll
    public void endTest() {
        System.out.println("Balance: " + bankAccount.getBalance());
    }
}
