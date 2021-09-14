package org.example.phoneBook.contactService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;

public class JsonSerializationContactService extends SerializationHelperAbstractClass {
    ObjectMapper objectMapper = new JsonMapper();

    @Override
    public void save() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("Contacts.json"), cache);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ContactList load() {
        if (cache == null) {
            try {
                cache = objectMapper.readValue(new File("Contacts.json"), ContactList.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cache;
    }
}
