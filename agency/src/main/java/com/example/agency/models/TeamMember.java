package com.example.agency.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team_members")
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;        // Üzvün adı, məsələn: "Murad Aliyev"
    private String role;        // Vəzifə: "Lead Developer"
    @Column(name = "image_url")
    private String imageUrl;    // Profil şəkilinin linki
    @Column(name = "facebook_url")
    private String facebookUrl; // Sosial media linkləri
    @Column(name = "twitter_url")
    private String twitterUrl;
    @Column(name = "linkedin_url")
    private String linkedinUrl;



}
