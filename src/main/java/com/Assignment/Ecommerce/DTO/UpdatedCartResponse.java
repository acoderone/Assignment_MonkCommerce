package com.Assignment.Ecommerce.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedCartResponse {
    private List<CartItemDTO> items;
    private Double totalPrice;
    private Double totalDiscount;
    private Double finalPrice;
}
