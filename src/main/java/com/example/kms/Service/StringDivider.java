package com.example.kms.Service;

import java.util.ArrayList;
import java.util.List;

public class StringDivider {
	
	private String string;
	
	private int divided_parts_number;

	public StringDivider(String string, int divided_parts_number) {
		super();
		this.string = string;
		this.divided_parts_number = divided_parts_number;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public int getDivided_parts_number() {
		return divided_parts_number;
	}

	public void setDivided_parts_number(int divided_parts_number) {
		this.divided_parts_number = divided_parts_number;
	}
	
	public List<String> divide() {
		int strLen = string.length();
		int number_of_chars_of_divided_string = strLen/divided_parts_number;
		List<String> divided_strings = new ArrayList<>();
		int start_index = 0 ;
		System.out.println(strLen);
		System.out.println(number_of_chars_of_divided_string);
		for (int i = 0 ; i<divided_parts_number - 1 ; i++) {
			divided_strings.add(string.substring(start_index, start_index+number_of_chars_of_divided_string));
			start_index += number_of_chars_of_divided_string;  
			System.out.println(start_index);
			System.out.println(divided_strings);
		}
		divided_strings.add(string.substring(start_index, strLen));
		System.out.println(divided_strings);
		return divided_strings ; 
	}

}

