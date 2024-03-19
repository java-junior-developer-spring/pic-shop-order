package com.picshop.order.dto;

import java.util.Map;

public class NewOrderDTORequest {
    private int userId;
    private Map<Integer, Integer> pictures;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Map<Integer, Integer> getPictures() {
        return pictures;
    }

    public void setPictures(Map<Integer, Integer> pictures) {
        this.pictures = pictures;
    }
}
