package com.xue.pojo;

import com.xue.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private String orderCode;
    private String address;
    private String post;
    private String receiver;
    private String mobile;
    private String userMessage;
    private Date createDate;
    private Date payDate;
    private Date deliveryDate;
    private Date confirmDate;
    private int uid;
    private String status;

    private List<OrderItem> orderItems;
    private User user;
    private float total;
    private int totalNumber;


    public String getCreateDate() {
        String createDateFormat = null;
        if (null != createDate) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            createDateFormat = simpleDateFormat.format(createDate);
        }
        return createDateFormat;
    }

    public String getPayDate() {
        String payDateFormat = null;
        if (null != payDate) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            payDateFormat = simpleDateFormat.format(payDate);
        }
        return payDateFormat;
    }

    public String getDeliveryDate() {
        String deliveryDateFormat = null;
        if (null != deliveryDate) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            deliveryDateFormat = simpleDateFormat.format(deliveryDate);
        }
        return deliveryDateFormat;
    }

    public String getConfirmDate() {
        String confirmDateFormat = null;
        if (null != confirmDate) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            confirmDateFormat = simpleDateFormat.format(confirmDate);
        }
        return confirmDateFormat;
    }

    public String getTotal() {
        DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
        return decimalFormat.format(total);
    }

    public String getStatusDesc() {
        String desc = "未知";
        switch (status) {
            case OrderService.waitPay:
                desc = "待付款";
                break;
            case OrderService.waitDelivery:
                desc = "待发货";
                break;
            case OrderService.waitConfirm:
                desc = "待收货";
                break;
            case OrderService.waitReview:
                desc = "等评价";
                break;
            case OrderService.finish:
                desc = "完成";
                break;
            case OrderService.delete:
                desc = "刪除";
                break;
            default:
                desc = "未知";
        }
        return desc;
    }
}
