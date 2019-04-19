package entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Check {
    private Long ID;
    private Administrator admin;
    private Administrator visitor;
    private LocalDateTime checkOpenDate;
    private LocalDateTime checkCloseDate;
    private Order order;
    private BigDecimal amount;

    public Check() {

    }

    private Check(CheckBuilder builder) {
        admin = builder._admin;
        visitor = builder._visitor;
        checkOpenDate = builder._checkOpenDate;
        order = builder._order;
        amount = builder._amount;
        checkCloseDate = LocalDateTime.now();
    }

    public static class CheckBuilder {
        private Administrator _admin;
        private Administrator _visitor;
        private LocalDateTime _checkOpenDate;
        private Order _order;
        private BigDecimal _amount;

        public CheckBuilder(Administrator admin, Administrator visitor) {
            this._admin = admin;
            this._visitor = visitor;
            _checkOpenDate = LocalDateTime.now();
        }

        public void order(Order order) {
            _order = order;
        }

        public void amount(BigDecimal amount) {
            _amount = amount;
        }
    }


    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    public Administrator getVisitor() {
        return visitor;
    }

    public void setVisitor(Administrator visitor) {
        this.visitor = visitor;
    }

    public LocalDateTime getCheckOpenDate() {
        return checkOpenDate;
    }

    public void setCheckOpenDate(LocalDateTime checkOpenDate) {
        this.checkOpenDate = checkOpenDate;
    }

    public LocalDateTime getCheckCloseDate() {
        return checkCloseDate;
    }

    public void setCheckCloseDate(LocalDateTime checkCloseDate) {
        this.checkCloseDate = checkCloseDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
