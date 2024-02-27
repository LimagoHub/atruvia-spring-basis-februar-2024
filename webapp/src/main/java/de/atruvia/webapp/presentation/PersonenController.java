package de.atruvia.webapp.presentation;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

@RestController
@RequestMapping("/personen")
public class PersonenController {

    @GetMapping(value = "/funktionen/gruss", produces = MediaType.TEXT_PLAIN_VALUE)
    public String gruss() {
        return  "Hallo Rest";
    }

    @Operation(summary = "Liefert eine Person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person gefunden",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonDto.class)) }),
            @ApiResponse(responseCode = "400", description = "ungueltige ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Person nicht gefunden",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "internal server error",
                    content = @Content)})

    @GetMapping(path="/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PersonDto> getPerson(@PathVariable UUID id) {

        // Service sucht Person zu dieser ID

        if(id.equals(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6")))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(PersonDto.builder().id(id).vorname("John").nachname("Doe").build());
    }
}
