package com.gpch.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Document(collection = "legends")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Legend {
    @Id
    private String id;
    @NotBlank(message="Please provide a Legend name.")
    private String name;
    private String team;
    private String fieldPosition;
    private String rating;
    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
    @NotNull(message="Please provide a date whit the format dd-MM-yyyy HH:mm")
    private LocalDateTime date;
}