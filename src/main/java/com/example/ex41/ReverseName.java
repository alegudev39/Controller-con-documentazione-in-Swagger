package com.example.ex41;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ex4")
@Tag(name = "Reverse Name")

public class ReverseName {

    private String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    @GetMapping("/name")
    @Operation(summary = "Get a name", description = "Returns a name from a Req. Param")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Name successfully added"),
            @ApiResponse(responseCode = "404", description = "Not found - The product was not found"),
            @ApiResponse(responseCode = "PersonalizedError", description = " Personalized Error just a try")
    })

    public String getName(@RequestParam @Parameter(name = "name", description = "Return the Name passed" ) String name) {
        return name;
    }

    @PostMapping("/reverseName")
    @Operation(summary = "Reverse a name", description = "Returns the reverse of a name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Name successfully reversed"),
            @ApiResponse(responseCode = "404", description = "Not found ")
    })

    public String getReversedName(@RequestParam @Parameter(name = "name to be reversed", description = "Return the name reversed") String name) {
        return reverseString(name);
    }


}