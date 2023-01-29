package tests.entities;

import entities.Account;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {
        // Arrange
        Account acc = new Account(1001L, 0.0);
        double amount = 200.0;
        double expectedValue = 196.0;

        // Act
        acc.deposit(amount);

        // Assert
        assertEquals(expectedValue, acc.getBalance());
    }
}
