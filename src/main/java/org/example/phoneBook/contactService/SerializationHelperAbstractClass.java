package org.example.phoneBook.contactService;

import lombok.Data;
import org.example.phoneBook.utils.ListUtils;

import java.util.stream.Collectors;

@Data
public abstract class SerializationHelperAbstractClass implements ContactsService {

    protected ContactList cache = null;

    @Override
    public ContactList getAll() {
        if (cache == null) cache = load();
        return cache;
    }

    @Override
    public void remove(int index) {
        if (cache.size() == 0) {
            System.out.println("Phonebook is empty");
        } else if (index < 0 || index >= cache.size()) {
            System.out.println("Incorrect input");
        } else {
            cache = load();
            cache.remove(index);
            save();
        }
    }

    @Override
    public void add(Contact contact) {

        if (cache == null) {
            cache = new ContactList();
            cache.add(contact);
        } else {
            cache.add(contact);
        }
        save();
    }

    @Override
    public ContactList findByName(String name) {
        if (cache == null) cache = load();
        return new ContactList(cache.getContacts().stream().filter(c->c.getName().contains(name)).collect(Collectors.toList()));
    }

}
