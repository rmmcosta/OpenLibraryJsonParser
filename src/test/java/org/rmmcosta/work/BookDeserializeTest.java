package org.rmmcosta.work;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class BookDeserializeTest {
    static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldParseAGivenWorkTitle() throws JsonProcessingException {
        String workJson = "{\"title\": \"Le verbe en action. grammaire contrastive des temps verbaux (fran\\u00e7ais, allemand, anglais, espagnol)\", \"covers\": [3140607], \"key\": \"/works/OL10000355W\", \"authors\": [{\"type\": {\"key\": \"/type/author_role\"}, \"author\": {\"key\": \"/authors/OL3965376A\"}}], \"type\": {\"key\": \"/type/work\"}, \"subjects\": [\"Comparative and general Grammar\", \"Verb\", \"Tense\", \"French language\", \"German language\", \"English language\", \"Spanish language\"], \"latest_revision\": 4, \"revision\": 4, \"created\": {\"type\": \"/type/datetime\", \"value\": \"2009-12-11T01:57:19.964652\"}, \"last_modified\": {\"type\": \"/type/datetime\", \"value\": \"2020-12-07T23:42:52.481900\"}}";
        Book book = objectMapper.readValue(workJson, Book.class);
        final String expectedTitle = "Le verbe en action. grammaire contrastive des temps verbaux (français, allemand, anglais, espagnol)";
        assertEquals(expectedTitle, book.title());
    }

    @Test
    void shouldParseAGivenWorkMainAuthor() throws JsonProcessingException {
        String workJson = "{\"title\": \"Le verbe en action. grammaire contrastive des temps verbaux (fran\\u00e7ais, allemand, anglais, espagnol)\", \"covers\": [3140607], \"key\": \"/works/OL10000355W\", \"authors\": [{\"type\": {\"key\": \"/type/author_role\"}, \"author\": {\"key\": \"/authors/OL3965376A\"}}], \"type\": {\"key\": \"/type/work\"}, \"subjects\": [\"Comparative and general Grammar\", \"Verb\", \"Tense\", \"French language\", \"German language\", \"English language\", \"Spanish language\"], \"latest_revision\": 4, \"revision\": 4, \"created\": {\"type\": \"/type/datetime\", \"value\": \"2009-12-11T01:57:19.964652\"}, \"last_modified\": {\"type\": \"/type/datetime\", \"value\": \"2020-12-07T23:42:52.481900\"}}";
        Book book = objectMapper.readValue(workJson, Book.class);
        final String expectedAuthorKey = "/authors/OL3965376A";
        assertEquals(expectedAuthorKey, book.authors()[0].author().key());
    }

    @Test
    void shouldParseAGivenWorkCreationDate() throws JsonProcessingException {
        String workJson = "{\"title\": \"Le verbe en action. grammaire contrastive des temps verbaux (fran\\u00e7ais, allemand, anglais, espagnol)\", \"covers\": [3140607], \"key\": \"/works/OL10000355W\", \"authors\": [{\"type\": {\"key\": \"/type/author_role\"}, \"author\": {\"key\": \"/authors/OL3965376A\"}}], \"type\": {\"key\": \"/type/work\"}, \"subjects\": [\"Comparative and general Grammar\", \"Verb\", \"Tense\", \"French language\", \"German language\", \"English language\", \"Spanish language\"], \"latest_revision\": 4, \"revision\": 4, \"created\": {\"type\": \"/type/datetime\", \"value\": \"2009-12-11T01:57:19.964652\"}, \"last_modified\": {\"type\": \"/type/datetime\", \"value\": \"2020-12-07T23:42:52.481900\"}}";
        Book book = objectMapper.readValue(workJson, Book.class);
        final LocalDate expectedCreationDate = LocalDate.of(2009, 12, 11);
        final String isoDateTimeString = book.created().value();
        final LocalDate actualCreationDate = LocalDate.parse(isoDateTimeString, DateTimeFormatter.ISO_DATE_TIME);
        assertEquals(expectedCreationDate, actualCreationDate);
    }
}