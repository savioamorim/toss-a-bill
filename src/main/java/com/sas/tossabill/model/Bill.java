package com.sas.tossabill.model;

import com.sas.tossabill.enumeration.CategoryEnum;
import com.sas.tossabill.enumeration.MonthEnum;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "bill")
public class Bill implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @NotNull
    private String title;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @NotNull
    private BigDecimal price;

    private String detail;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MonthEnum month;

    @NotNull
    private String year;

    @Column(columnDefinition = "boolean default false")
    private Boolean archived = false;

}
