package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldThrowExceptionIfMinBalanceGreaterMaxBalance() { //должно вызываться исключение, если минимальный баланс больше максимального баланса
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000, 11_000, 10_000, 5);
        });
    }

    @Test
    public void shouldThrowExceptionIfRateIsNegative() { //должен выдать исключение, если ставка отрицательна
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000, 1_000, 10_000,-5);
        });
    }

    @Test
    public void shouldThrowExceptionIfBalanceIsNegative() { //должно вызывать исключение, если баланс отрицательный
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(-2000, 1_000, 10_000,5);
        });
    }

    @Test
    public void whenAfterPurchaseBalanceIsNegative() { //когда баланс после покупки отрицательный
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void whenAfterPurchaseBalanceIsLessThanMinBalance() { //когда баланс после покупки меньше минимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(2_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void whenAfterPurchaseBalanceMoreThanMinBalance() { //когда баланс после покупки превышает минимальный баланс
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void whenAfterPurchaseBalanceEqualToMinBalance() { //когда баланс после покупки равен минимальному балансу
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void whenAmountEqualToZero() { //когда сумма покупки равна нулю
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void whenAfterAddBalanceIsLessThanMaxBalance() { //когда баланс после добавления меньше максимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(7_000);

        Assertions.assertEquals(9_000, account.getBalance());
    }

    @Test
    public void whenAfterAddBalanceIsMoreThanMaxBalance() { //когда баланс после добавления превышает максимальный баланс
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void whenAfterAddBalanceEqualMaxBalance() { //когда после добавления баланс равен максимальному балансу
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddZero() { //следует добавить ноль
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldCalculateAmountPercent() { //следует рассчитать сумму процентов
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(100, account.yearChange());
    }

    @Test
    public void ifMinBalanceEqualZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.getMinBalance());
    }

    @Test
    public void ifMaxBalanceEqualZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                0,
                5
        );

        Assertions.assertEquals(0, account.getMaxBalance());
    }
}
