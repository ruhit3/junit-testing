import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountAssumptionsTest {

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);

        // if true -> continue test | if false -> abort test
        assumeTrue(bankAccount != null, "Account is null");
        assertTrue(bankAccount.isActive());

        // if true -> run executable | if false -> pass/ignore
        assumingThat(bankAccount == null, () -> assertFalse(bankAccount.isActive()));
    }
}
