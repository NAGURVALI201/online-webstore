package com.ecommerce.webstore.DTO;


import com.ecommerce.webstore.model.Category;
import com.ecommerce.webstore.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    public Product toProduct()
    {
        Product p = new Product();
        p.setId(this.getId());
        p.setTitle(this.getTitle());
        p.setPrice(this.getPrice());
        p.setDescription(this.getDescription());
        p.setImageUrl(this.getImage());

        Category c = new Category();
        c.setName(this.getCategory());
        p.setCategory(c);

        return p;
    }
}
