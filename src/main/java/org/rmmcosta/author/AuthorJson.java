package org.rmmcosta.author;

import org.rmmcosta.work.LastModified;
import org.rmmcosta.work.Type;

public record AuthorJson(String name, LastModified last_modified, String key, Type type, int revision) {
}
