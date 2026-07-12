package edu.uncg.assignment3;

import java.nio.file.Path;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "creatures")
@Data
@NoArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String ingameDescription;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String thumbnailPath;

    @Column(nullable = false)
    private String mainImagePath;

    @Column(nullable = false)
    private boolean isAvatar;

    @Column(nullable = false)
    private boolean isSpider;

    @Column(nullable = false)
    private boolean isPassive;

    @Column(nullable = false)
    private boolean isAggressive;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Character(String name, String description, String ingameDescription, String origin, Path thumbnailPath, Path mainImagePath, boolean isAvatar, boolean isSpider, boolean isPassive, boolean isAggressive) {
        this.name = name;
        this.description = description;
        this.ingameDescription = ingameDescription;
        this.origin = origin;
        this.thumbnailPath = thumbnailPath.toString();
        this.mainImagePath = mainImagePath.toString();
        this.isAvatar = isAvatar;
        this.isSpider = isSpider;
        this.isPassive = isPassive;
        this.isAggressive = isAggressive;
    }
}
