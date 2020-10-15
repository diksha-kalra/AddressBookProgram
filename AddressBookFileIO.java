package com.addressbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookFileIO {
	public static String ADDRESS_BOOK = "address-book-file.txt";

	public void writeData(ArrayList<PersonInfo> person) throws IOException {
		StringBuffer empBuffer = new StringBuffer();
		person.forEach(personInBook -> {
			String personDataString = personInBook.toString().concat("\n");
			empBuffer.append(personDataString);
		});
		try {
			Files.write(Paths.get(ADDRESS_BOOK), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Object readData() {
		List<PersonInfo> person = new ArrayList<>();
		try {
			Files.lines(new File(ADDRESS_BOOK).toPath()).map(line -> line.trim())
					.forEach(line -> System.out.println(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return person;
	}
}