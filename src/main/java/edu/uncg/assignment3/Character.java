package edu.uncg.assignment3;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "creatures")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long characterId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String ingameDescription;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private boolean isAvatar;

    @Column(nullable = false)
    private boolean isSpider;

    @Column(nullable = false)
    private boolean isPassive;

    @Column(nullable = false)
    private boolean isAggressive;

    @JsonFormat(pattern = "yyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    public Character(String name, String description, String ingameDescription,
            String origin, boolean isAvatar, boolean isSpider, boolean isPassive, boolean isAggressive) {
        this.name = name;
        this.description = description;
        this.ingameDescription = ingameDescription;
        this.origin = origin;
        this.isAvatar = isAvatar;
        this.isSpider = isSpider;
        this.isPassive = isPassive;
        this.isAggressive = isAggressive;
    }

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        this.createdAt = LocalDateTime.now();
    }
}
