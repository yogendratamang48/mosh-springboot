package com.ytamang.store.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "bio")
    private String bio;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "loyalty_points")
    private Integer loyaltyPoints;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    @MapsId
    @ToString.Exclude
    private User user;
}
