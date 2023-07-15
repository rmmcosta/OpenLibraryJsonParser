package org.rmmcosta.work;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.rmmcosta.author.AuthorJson;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorDeserializeTest {
    static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldParseAuthorName() throws JsonProcessingException {
        String authorJson = "{\"name\": \"Colombe Plante\", \"last_modified\": {\"type\": \"/type/datetime\", \"value\": \"2008-04-30T20:50:18.033121\"}, \"key\": \"/authors/OL3980739A\", \"type\": {\"key\": \"/type/author\"}, \"revision\": 1}";
        AuthorJson author = objectMapper.readValue(authorJson, AuthorJson.class);
        String expectedName = "Colombe Plante";
        assertEquals(expectedName, author.name());
    }

    @Test
    void shouldParseAuthorKey() throws JsonProcessingException {
        String authorJson = "{\"name\": \"Colombe Plante\", \"last_modified\": {\"type\": \"/type/datetime\", \"value\": \"2008-04-30T20:50:18.033121\"}, \"key\": \"/authors/OL3980739A\", \"type\": {\"key\": \"/type/author\"}, \"revision\": 1}";
        AuthorJson author = objectMapper.readValue(authorJson, AuthorJson.class);
        String expectedKey = "/authors/OL3980739A";
        assertEquals(expectedKey, author.key());
    }
}
