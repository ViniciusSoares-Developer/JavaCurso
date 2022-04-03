package model.entites;

import model.exception.DomainException;

public class Account{
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        setNumber(number);
        setHolder(holder);
        setBalance(balance);
        setWithdrawLimit(withdrawLimit);
    }

    @Override
    public String toString() {
        return  "number: " + number +
                ", holder: " + holder +
                ", balance: " + balance +
                ", withdrawLimit: " + withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getHolder() {
        return holder;
    }
    public void setHolder(String holder) {
        this.holder = holder;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public Double getWithdrawLimit() {
        return withdrawLimit;
    }
    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void withdraw(double value){
        if(getBalance() == 0){
            throw new DomainException("Balance equal to 0, impossible to withdraw");
        }
        if(value > getWithdrawLimit()){
            throw new DomainException("Insufficient cashout limit for cashout");
        }
        setBalance(getBalance()-value);
    }
    public void deposit(double value){
        setBalance(getBalance()+value);
    }
}
