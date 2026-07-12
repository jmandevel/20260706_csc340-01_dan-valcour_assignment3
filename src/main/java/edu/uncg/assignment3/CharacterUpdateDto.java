package edu.uncg.assignment3;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterUpdateDto {
    private String name;
    private String description;
    private String ingameDescription;
    private String origin;
}
