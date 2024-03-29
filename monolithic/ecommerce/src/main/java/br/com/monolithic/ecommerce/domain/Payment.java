package br.com.monolithic.ecommerce.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Payment extends AbstractDomain {

    @Id
    private String id;
    @DBRef
    private Order order;

    public Payment(Order order) {
        this.order = order;
    }

}
