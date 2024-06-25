package example.dto;

import java.util.UUID;

public record PackingItemDto(UUID uuid, String name, Integer quantity, Boolean isPackied) {

}
