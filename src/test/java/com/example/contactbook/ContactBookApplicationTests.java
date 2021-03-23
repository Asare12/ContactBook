package com.example.contactbook;

import com.example.contactbook.entities.ContactBookEntity;
import com.example.contactbook.service.ContactBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactBookApplicationTests {

	@Autowired
	private ContactBookService service;
	private ContactBookEntity contact = new ContactBookEntity();
	private List<ContactBookEntity> contactBookList;

	@Test
	void contextLoads() {
	}

	/**
	 * When: The user searches for contact id 1
	 * Then: My contact book should return one contact with the name issac
	 */
	@Test
	void getContactById_returnIssacForID1(){
		whenSearchContactWithID1();
		thenReturnOneContactIssacForID1();
	}

	private void whenSearchContactWithID1() {
		contact = service.getContactById(1);
	}

	private void thenReturnOneContactIssacForID1() {
		String name = contact.getName();
		assertEquals("Issac", name);
	}

	/**
	 * When: The user saves a contact in contact book
	 * Then: My contact book should save contact details and return it
	 */
	@Test
    void saveContact_validateReturnContactWithDetails(){
	    whenUserCreatesNewContactAndSaves();
	    thenCreatesNewContactRecordAndReturnsIt();
    }

	private void whenUserCreatesNewContactAndSaves() {
		contact.setName("David");
		contact.setEmail("david.asare@email.com");
		contact.setPhoneNumber("0771234567");
	}

    private void thenCreatesNewContactRecordAndReturnsIt() {
		ContactBookEntity newContact = service.saveContact(contact);
		assertEquals(contact, newContact);
    }

	/**
	 * When: The user deletes a contact in contact book
	 * Then: My contact book should delete that specific contact details and I should have less contacts in my contact book
	 */
	@Test
	void deleteContact_validateContactDavidForID4HasBeenRemoved(){
		whenDeletesExistingContactDavidByName();
		thenDeletingShouldBeSuccessful();
	}

	private void thenDeletingShouldBeSuccessful() {
		contactBookList = service.getContacts();
		assertEquals(3,contactBookList.size());
	}

	private void whenDeletesExistingContactDavidByName() {
		service.removeContact("David");
	}

	/**
	 * When: The user tries to update a specific contact
	 * Then: My contact book should update that specific contact details and show me that contact has been visibly changed
	 */
	@Test
	void editContact_updateContactAnnaEmailHasBeenChanged(){
		whenEnterNewEmailDetails();
		thenAnnaDetailsHasBeenUpdated();

	}

	private void thenAnnaDetailsHasBeenUpdated() {
		ContactBookEntity updatedContact = service.updateContact(contact);
		ContactBookEntity previousContact = service.getContactById(2);
		assertNotEquals(previousContact,updatedContact);
	}

	private void whenEnterNewEmailDetails() {
		contact.setContactBookId(2);
		contact.setEmail("anna2456@email.com");
		contact.setName("Anna");
		contact.setPhoneNumber("0771234567");
	}

}
