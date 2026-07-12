package edu.uncg.assignment3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterCreateDto {
    private String name;
    private String description;
    private String ingameDescription;
    private String origin;
    private boolean isAvatar;
    private boolean isSpider;
    private boolean isPassive;
    private boolean isAggressive; 
}
