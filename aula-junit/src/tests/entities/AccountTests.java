package tests.entities;

import entities.Account;
import org.junit.Test;
import tests.factory.AccountFactory;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {
        // Arrange
        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = AccountFactory.createEmptyAccount();

        // Act
        acc.deposit(amount);

        // Assert
        assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount() {
        // Arrange
        double expectedValue = 100.0;
        Account acc = AccountFactory.createAccount(expectedValue);
        double amount = -200.0;

        // Act
        acc.deposit(amount);

        // Assert
        assertEquals(expectedValue, acc.getBalance());
    }
    @Test
    public void fullWithdrawShouldClearBalance() {
        // Arrange
        double expectedValue = 0.0;
        double amount = 800.0;
        Account acc = AccountFactory.createAccount(amount);

        // Act
        double result = acc.fullWithdraw();

        // Assert
        assertEquals(expectedValue, acc.getBalance());
        assertEquals(amount, result);
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
        // Arrange
        double expectedValue = 300.0;
        double withdraw = 500.0;
        Account acc = AccountFactory.createAccount(800.0);

        // Act
        acc.withdraw(withdraw);

        // Assert
        assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            double expectedValue = 800.0;
            double withdraw = 900.0;
            Account acc = AccountFactory.createAccount(800.0);
            acc.withdraw(withdraw);
        });
    }
}
