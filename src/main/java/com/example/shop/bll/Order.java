package com.example.shop.bll;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "order_total")
    private int total;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Column(name = "order_status")
    private OrderStatus status;
    @Column(name="user_id")
    private long userId;

    public Order(long id, int total, LocalDateTime dateTime, OrderStatus status, long userId) {
        this.id = id;
        this.total = total;
        this.dateTime = dateTime;
        this.status = status;
        this.userId = userId;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
