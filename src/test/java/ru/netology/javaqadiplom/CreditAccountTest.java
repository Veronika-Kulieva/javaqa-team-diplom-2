package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() { //добавить к положительному балансу
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }
    @Test
    public void shouldAddZeroToPositiveBalance() { //добавить 0 к положительному балансу
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldNotAddNegativeBalance() { //не должен добавлять отрицательный баланс
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.add(-1_000);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void enterZeroInitialBalance() { //ввести нулевой начальный баланс
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void enterZeroCreditLimit() { //ввести нулевой кредитный лимит
        CreditAccount account = new CreditAccount(
                500,
                0,
                15
        );

        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void enterZeroRate() { //ввести нулевую ставку
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                0
        );

        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    public void shouldBeThrowExceptionWhenNegativeBalance() { //должно быть исключение при отрицательном балансе

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-500, 5_000, 15);
        });
    }

    @Test
    public void shouldBeThrowExceptionWhenNegativeCreditLimit() { // должно быть исключение при отрицательном кредитном лимите

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(500, -5_000, 15);
        });
    }

    @Test
    public void shouldBeThrowExceptionWhenNegativeRate() { //должно быть исключение при отрицательной ставке

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(500, 5_000, -15);
        });
    }

    @Test
    public void shouldDecreaseBalanceWhenAmountPositive() { // при положительной сумме должен уменьшится баланс
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(200);

        Assertions.assertEquals(300, account.getBalance());
    }

    @Test
    public void shouldNotChangeBalanceWhenAmountZero() { //не должен менять баланс, когда сумма равна 0
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(0);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldZeroBalanceWhenSameAmount() { //должен быть нулевой баланс при той же сумме
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(500);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldDecreaseToMinusBalanceWhenAmountWithinLimit() { //должен уменьшаться до минусового баланса когда сумма находится в пределах лимита
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(-500, account.getBalance());
    }

    @Test
    public void shouldDecreaseToMinusBalanceWhenAmountPlusBalanceEqualLimit() { //должно уменьшаться до минусового баланса, когда сумма + баланс равны лимиту
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(5_500);

        Assertions.assertEquals(-5_000, account.getBalance());
    }

    @Test
    public void shouldNotChangeBalanceWhenAmountPlusBalanceMoreThanLimit() { //не должен изменять баланс когда сумма + баланс больше лимита
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(8_000);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldNotChangeBalanceWhenAmountNegative() { //не должен изменять баланс когда сумма отрицательная
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(-2_000);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldNotCalculatePercentOnThePositiveBalance() { //не должен начислять проценты на положительный баланс
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(200);

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldNotCalculatePercentOnAZeroBalance() { //не должен начислять проценты на нулевой баланс
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(500);

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalculatePercentOnTheNegativeBalance() { //должен начислять проценты на отрицательный баланс
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(1_500);

        Assertions.assertEquals(-150, account.yearChange());
    }

    @Test
    public void shouldAddToPositiveBalance1() { //должен добавить к положительному балансу
        CreditAccount account = new CreditAccount(
                300,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_300, account.getBalance());
    }
}
