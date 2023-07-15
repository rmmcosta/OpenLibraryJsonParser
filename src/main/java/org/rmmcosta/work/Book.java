package org.rmmcosta.work;

public record Book(String title, int[] covers, String key, WorkAuthorJson[] authors, Type type, String[] subjects, int latest_revision, int revision, Created created, LastModified last_modified) {}

