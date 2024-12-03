package com.example.gotalk.account;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter@Setter@EqualsAndHashCode(of = "id")
@Builder@AllArgsConstructor@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Id @GeneratedValue
    Long id;

    @Column(unique = true)
    String email;

    @Column(unique = true)
    String nickname;

    String password;

    boolean emailVerified;

    String emailCheckToken;

    LocalDateTime emailCheckTokenGeneratedAt;

    LocalDateTime joinedAt;

    String bio;

    String url;

    String occupation;

    String location;

    @Lob
    @Basic(fetch = FetchType.EAGER)
    String profileImage;

    boolean studyCreatedByEmail;

    boolean studyCreatedByWeb = true;

    boolean studyEnrollmentResultByEmail;

    boolean studyEnrollmentResultByWeb = true;

    boolean studyUpdatedByEmail;

    boolean studyUpdatedByWeb = true;

    public void generateEmailCheckToken() {
        this.emailCheckToken = UUID.randomUUID().toString();
    }
}
