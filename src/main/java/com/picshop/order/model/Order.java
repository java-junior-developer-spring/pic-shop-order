package com.picshop.order.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("pic_shop_order")
public class Order {
    // уникальный идентификатор записи
    @MongoId
    private UUID id;
    // - похожи на индексы в sql
    // - могут быть составными (но не по всем полям)
    // - хранятся отдельно в упорядоченном виде
    // - не могут создавать связей с другими документами
    // - замедляют вставку данных
    @Indexed
    private int userId;
    @JsonProperty("ordered_at")
    private LocalDateTime orderedAt;
    @JsonProperty("pictures_ids")
    private List<Integer> picturesIds;

    public Order() {
    }

    public Order(UUID id, int userId, LocalDateTime orderedAt, List<Integer> picturesIds) {
        this.id = id;
        this.userId = userId;
        this.orderedAt = orderedAt;
        this.picturesIds = picturesIds;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
    }

    public List<Integer> getPicturesIds() {
        return picturesIds;
    }

    public void setPicturesIds(List<Integer> picturesIds) {
        this.picturesIds = picturesIds;
    }
}
