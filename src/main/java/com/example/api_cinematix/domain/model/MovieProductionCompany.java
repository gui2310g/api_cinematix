package com.example.api_cinematix.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "production_companies")
@Data
public class MovieProductionCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProductionCompany")
    private Long id;

    @Column(name = "logo")
    private String logo_path;

    private String name;

    @Column(name = "country")
    private String origin_country;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idMovie", referencedColumnName = "idMovie")
    @JsonIgnore
    private Movie movie;
}
