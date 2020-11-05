package com.sas.tossabill.model;

import com.sas.tossabill.enumeration.CategoryEnum;
import com.sun.istack.NotNull;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @NotNull
    private String title;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    private String place;

    @NotNull
    private BigDecimal price;

    private String details;

    @CreatedDate
    private LocalDateTime createdAt;

    @Column(columnDefinition = "boolean default false")
    private Boolean archived = false;

}
