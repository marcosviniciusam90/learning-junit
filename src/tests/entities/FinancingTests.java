package tests.entities;

import entities.Financing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinancingTests {

    @Test
    public void entryShouldReturnTwentyPercentOfTotalAmount() {
        Financing financing = new Financing(10000.0, 2000.0, 10);
        double result = financing.entry();
        Assertions.assertEquals(2000.0, result);
    }

    @Test
    public void quotaShouldReturnCorrectQuotaValue() {
        Financing financing = new Financing(10000.0, 2000.0, 10);
        double result = financing.quota();
        Assertions.assertEquals(800.0, result);
    }

    @Test
    public void constructorShouldSetValuesWhenValidData() {
        double totalAmount = 10000.0;
        double income = 2000.0;
        Integer months = 8;
        Financing financing = new Financing(totalAmount, income, months);
        Assertions.assertEquals(totalAmount, financing.getTotalAmount());
        Assertions.assertEquals(income, financing.getIncome());
        Assertions.assertEquals(months, financing.getMonths());
    }

    @Test
    public void constructorShouldReturnExceptionWhenInvalidData() {
        double totalAmount = 10000.0;
        double income = 1999.9;
        Integer months = 8;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = new Financing(totalAmount, income, months);
        });
    }

    @Test
    public void setTotalAmountShouldSetValueWhenValidData() {
        double totalAmount = 100000.0;
        double income = 2000.0;
        Integer months = 80;
        Financing financing = new Financing(totalAmount, income, months);

        Double expectedValue = 98000.0;
        financing.setTotalAmount(expectedValue);
        Assertions.assertEquals(expectedValue, financing.getTotalAmount());
    }

    @Test
    public void setTotalAmountShouldReturnExceptionWhenInvalidData() {
        double totalAmount = 100000.0;
        double income = 2000.0;
        Integer months = 80;
        Financing financing = new Financing(totalAmount, income, months);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            financing.setTotalAmount(101000.0);
        });
    }

    @Test
    public void setIncomeShouldSetValueWhenValidData() {
        double totalAmount = 100000.0;
        double income = 2000.0;
        Integer months = 80;
        Financing financing = new Financing(totalAmount, income, months);

        Double expectedValue = 2001.0;
        financing.setIncome(expectedValue);
        Assertions.assertEquals(expectedValue, financing.getIncome());
    }

    @Test
    public void setIncomeShouldReturnExceptionWhenInvalidData() {
        double totalAmount = 100000.0;
        double income = 2000.0;
        Integer months = 80;
        Financing financing = new Financing(totalAmount, income, months);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            financing.setIncome(1999.9);
        });
    }

    @Test
    public void setMonthsShouldSetValueWhenValidData() {
        double totalAmount = 100000.0;
        double income = 2000.0;
        Integer months = 80;
        Financing financing = new Financing(totalAmount, income, months);

        Integer expectedValue = 81;
        financing.setMonths(expectedValue);
        Assertions.assertEquals(expectedValue, financing.getMonths());
    }

    @Test
    public void setMonthsShouldReturnExceptionWhenInvalidData() {
        double totalAmount = 100000.0;
        double income = 2000.0;
        Integer months = 80;
        Financing financing = new Financing(totalAmount, income, months);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            financing.setMonths(79);
        });
    }
}
