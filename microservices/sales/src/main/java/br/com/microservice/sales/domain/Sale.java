package br.com.microservice.sales.domain;

import br.com.microservice.sales.enums.EntityStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Sale {

    @Id
    private String id;
    @NotBlank
    private String productId;
    @NotBlank
    private String userId;
    private EntityStatusEnum status = EntityStatusEnum.ACTIVE;

    public Sale(String productId, String userId) {
        this.productId = productId;
        this.userId = userId;
    }
}
