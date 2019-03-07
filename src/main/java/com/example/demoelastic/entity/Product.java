package com.example.demoelastic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author mustley
 * @version $Revision: $<br/>
 * $Id: $
 * @since 07/03/19 13:57
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "test-product", type = "product")
public class Product {

    @Id
    private String id;

    private String name;

}
