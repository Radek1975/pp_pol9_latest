package pl.sdacademy.phonebook.controller;

import pl.sdacademy.phonebook.model.Model;
import pl.sdacademy.phonebook.model.entity.Contact;
import pl.sdacademy.phonebook.view.PhoneBookEng;
import pl.sdacademy.phonebook.view.PhoneBookPL;
import pl.sdacademy.phonebook.view.PhoneBookView;

import java.util.List;

public class PhoneBookController {
    private Model model;
    private PhoneBookView view;

    public PhoneBookController() {
        model = new Model();
        view = new PhoneBookPL();
    }

    public void terminator() {
        int option = -1;
        while (option != 0) {
            option = view.showMenuAndGetOption();
            switch (option) {
                case 1: handleShowAllAction(); break;
                case 2: handleAddContactAction(); break;
                case 3: handleDeleteContactAction(); break;
                case 4: handleLanguageChangeAction(); break;
            }
        }
    }

    private void handleLanguageChangeAction() {
        int option = view.showLanguageSelectMenu();
        if(option == 0) {
            view = new PhoneBookPL();
        } else if(option == 1) {
            view = new PhoneBookEng();
        }
    }

    private void handleDeleteContactAction() {
        Integer contactIndex = view.showContactToDeleteMessage();
        model.deleteContact(contactIndex);
    }

    private void handleAddContactAction() {
        Contact contact = view.getContactFromUser();
        model.addContact(contact);
    }

    private void handleShowAllAction() {
        List<Contact> contactList = model.getList();
        view.showAllContacts(contactList);
    }
}
