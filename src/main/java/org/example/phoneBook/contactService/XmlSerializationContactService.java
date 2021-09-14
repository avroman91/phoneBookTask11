package org.example.phoneBook.contactService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class XmlSerializationContactService extends SerializationHelperAbstractClass {

    ObjectMapper objectMapper = new XmlMapper();

    @Override
    public void save() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("Contacts.xml"), cache);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ContactList load() {
        if (cache == null) {
            try {
                cache = objectMapper.readValue(new File("Contacts.xml"), ContactList.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cache;
    }
}
