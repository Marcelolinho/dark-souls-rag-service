package org.mpp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "character_data", uniqueConstraints = {
        @UniqueConstraint(name = "ck_character_name", columnNames = {"name"})
})
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class DarkSoulsDataModel extends DarkSoulsDataBaseEntity {

    @Id
    @GeneratedValue(generator = "gen_id_dark_souls_data", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen_id_dark_souls_data", sequenceName = "seq_id_dark_souls_data", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private DarkSoulsCategoryEnum category;

    @Column(name = "description", length = 4000)
    private String description;

    @Column(name = "embeddings", comment = "this is the description embedded")
    private List<Double> embeddings;
}
