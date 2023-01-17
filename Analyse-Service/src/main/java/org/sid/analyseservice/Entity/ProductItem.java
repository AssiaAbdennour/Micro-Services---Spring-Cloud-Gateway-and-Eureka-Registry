package org.sid.analyseservice.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItem {
    private Long id;
    private double quantity;
    private double price;
    private String productId;
    private Bill bill;
}
