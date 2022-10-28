package site.metacoding.firstapp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEditDto {
	private String productName;
	private Integer productPrice;
	private Integer productQty;
}
