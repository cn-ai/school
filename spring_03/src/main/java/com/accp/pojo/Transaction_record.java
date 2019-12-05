package com.accp.pojo;

import java.util.Date;

public class Transaction_record {
	public int id;
	public String cardno;// 卡号
	public Date transaction_Date;// 交易日期
	public int expense;// 支出
	public int income;// 存入
	public int balance;// 账户余额
	public String transaction_Type;// 交易类型
	public String remark;// 备注

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public Date getTransactionDate() {
		return transaction_Date;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transaction_Date = transactionDate;
	}

	public int getExpense() {
		return expense;
	}

	public void setExpense(int expense) {
		this.expense = expense;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getTransactionType() {
		return transaction_Type;
	}

	public void setTransactionType(String transactionType) {
		this.transaction_Type = transactionType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
public Transaction_record() {
	// TODO Auto-generated constructor stub
}

public Transaction_record(int id, String cardno, Date transactionDate, int expense, int balance,
		String transactionType) {
	super();
	this.id = id;
	this.cardno = cardno;
	this.transaction_Date = transactionDate;
	this.expense = expense;
	this.balance = balance;
	this.transaction_Type = transactionType;
}

}
