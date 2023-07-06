package uz.pdp.pcmarket.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;

    private String title;

    private Integer categoryId;

    private Integer brandId;

    private double price;

    private Integer attachmentId;

    private String specification;

    private Integer reviewId;

    private String guarantee;
}
