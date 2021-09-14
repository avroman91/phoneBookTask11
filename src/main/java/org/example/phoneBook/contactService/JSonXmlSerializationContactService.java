package org.example.phoneBook.contactService;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import java.io.*;

@AllArgsConstructor
public class JSonXmlSerializationContactService extends SerializationHelperAbstractClass {

    ObjectMapper objectMapper;
    String path;

    @Override
    public void save() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), cache);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ContactList load() {
        if (cache == null) {
            try {
                cache = objectMapper.readValue(new File(path), ContactList.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cache;
    }
}
