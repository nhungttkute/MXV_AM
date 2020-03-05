package com.newgen.am.dto;

public class UserResponseDTO {

    private Integer id;
    private String username;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String email;
    private String accountNo;
    private Long availableBalance;
    private Long positionLimit;
    private Long orderLimit;
    private Long depositRatio;
    private Boolean logined;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getPositionLimit() {
        return positionLimit;
    }

    public void setPositionLimit(Long positionLimit) {
        this.positionLimit = positionLimit;
    }

    public Long getOrderLimit() {
        return orderLimit;
    }

    public void setOrderLimit(Long orderLimit) {
        this.orderLimit = orderLimit;
    }

    public Long getDepositRatio() {
        return depositRatio;
    }

    public void setDepositRatio(Long depositRatio) {
        this.depositRatio = depositRatio;
    }

    public Boolean getLogined() {
        return logined;
    }

    public void setLogined(Boolean logined) {
        this.logined = logined;
    }

}
