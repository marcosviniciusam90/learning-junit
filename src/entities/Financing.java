package entities;

public class Financing {

    private static final double ENTRY_PERCENT_OF_TOTAL_AMOUNT = 0.2;

    private Double totalAmount;
    private Double income;
    private Integer months;

    public Financing() {
    }

    public Financing(Double totalAmount, Double income, Integer months) {
        checkFinancingCondition(totalAmount, income, months);
        this.totalAmount = totalAmount;
        this.income = income;
        this.months = months;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        checkFinancingCondition(totalAmount, income, months);
        this.totalAmount = totalAmount;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        checkFinancingCondition(totalAmount, income, months);
        this.income = income;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        checkFinancingCondition(totalAmount, income, months);
        this.months = months;
    }

    public double entry() {
        return totalAmount * ENTRY_PERCENT_OF_TOTAL_AMOUNT;
    }

    public double quota() {
        return (totalAmount - entry()) / months;
    }

    private void checkFinancingCondition(Double totalAmount, Double income, Integer months) {
        double entry = totalAmount * ENTRY_PERCENT_OF_TOTAL_AMOUNT;
        if( (totalAmount - entry) / months > income / 2.0 ) {
            throw new IllegalArgumentException("A prestação não pode ser maior que metade da renda");
        }
    }
}
