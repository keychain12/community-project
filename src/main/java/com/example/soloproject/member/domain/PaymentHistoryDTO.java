package com.example.soloproject.member.domain;

import lombok.Data;

@Data
public class PaymentHistoryDTO {
    private String payment_id;
    private String user_seq;
    private String icon_seq;
    private String payment_date;
    private String name;
    private String pic;
    private String price;
}
