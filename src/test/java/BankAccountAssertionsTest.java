import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount class")
public class BankAccountAssertionsTest {

    @Test
    @DisplayName("Withdraw 500 successfully")
    public void testWithdraw() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdrawNotStuckAtZero() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test no exceptions for withdraw and deposit")
    public void testWithdrawAndDepositWithoutExceptions() {
        BankAccount bankAccount = new BankAccount(400, 0);
        fail();
        assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(450));
    }

    @Test
    @DisplayName("Test speed deposit")
    public void testDepositTimeout() {
        BankAccount bankAccount = new BankAccount(400, 0);
        assertTimeout(Duration.ofMillis(200), () -> bankAccount.deposit(200));
        assertEquals(0.33, 1 / (double) 3, 0.01, "Not the same!");
    }
}
