package cse222.hw3.part2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
/**
 * Modify a given text
 * @author murat
 *
 */
public class SimpleTextEditor {
	/**
	 * Holds given text as a list
	 */
	private List<Character> text;
	
	/**
	 * Set text to given
	 * @param given will be setted to text
	 */
	public SimpleTextEditor( List<Character> given) {
		text = given;
	}
	/**
	 * Returns size of text
	 * @return size of text
	 */
	public int size() {
		return text.size();
	}
	
	/**
	 * Read characters from text and add them to the list
	 * @param file file that will be readed from
	 * @throws IOException when fileInputStream can not be opened
	 */
	public void readFromFile( File file) throws IOException {
		int data ;
		FileReader fileInputStream = null ;
		fileInputStream = new FileReader( file ) ;

		data = fileInputStream.read() ;
		while( data != -1){
			
			if( (char) data != '\r' ) {
				text.add((char) data);
			}
			data = fileInputStream.read() ;
		}

		fileInputStream.close() ;
	}

	/**
	 * Read characters from text and add them to the list with iterator
	 * @param file file that will be readed from
	 * @throws IOException when fileInputStream can not be opened
	 */
	public void readFromFileItr( File file) throws IOException {
		
		int data ;
		ListIterator<Character> listIter = text.listIterator(0);
		FileReader fileInputStream = null ;

		fileInputStream = new FileReader( file ) ;

		data = fileInputStream.read() ;
		while( data != -1){
			
			if( (char) data != '\r' ) {
				listIter.add( (char) data);
			}
			data = fileInputStream.read() ;
		}

		fileInputStream.close() ;
	}

	/**
	 * Adds a given string to indexed position of the list
	 * @param index that points to position where will string be added
	 * @param str string that will be added
	 */
	public void addStringToText( int index, String str ){
		int i = 0;
		while( str.length() > i ){
			text.add(index, str.charAt(i));
			i++;
			index++;
		}
	}
	
	/**
	 * Adds a given string to indexed position of the list with iterator
	 * @param index that points to position where will string be added
	 * @param str string that will be added
	 */
	public void addStringToTextItr( int index, String str ){
		ListIterator<Character> listIter = text.listIterator(index);
		int i = 0;
		while( str.length() > i ){
			listIter.add(str.charAt(i));
			i++;
		}
	}
	
	/**
	 * Finds the first occurence of given string and returns index of start of the string, otherwise returns -1
	 * @param str string that will be searched
	 * @return returns index of start of the string which is found, otherwise returns -1
	 */
	public int findStringInText( String str ){
		int textCursor = 0;
		int strCursor = 0;
		boolean found = false;

		while( !found && (textCursor < text.size()) ){
			if ( text.get(textCursor) == str.charAt(strCursor) ){
				strCursor++;
				if ( strCursor == str.length()-1 )
					found = true;
			}
			else
				strCursor = 0;

			textCursor++;
		}
		if( found )
			return textCursor - strCursor;
		else
			return -1;
	}
	
	/**
	 * Finds the first occurence of given string with iterator and returns index of start of the string , otherwise returns -1
	 * @param str string that will be searched
	 * @return returns index of start of the string which is found, otherwise returns -1
	 */
	public int findStringInTextItr( String str ){
		int strCursor = 0;
		int textCursor = 0;
		boolean found = false;
		ListIterator<Character> listIter = text.listIterator(0);

		while( !found && listIter.hasNext() ){
			if ( listIter.next() == str.charAt(strCursor) ){
				strCursor++;
				if ( strCursor == str.length()-1 )
					found = true;
			}
			else
				strCursor = 0;

			textCursor++;
		}
		if( found )
			return textCursor - strCursor;
		else
			return -1;
	}

	/**
	 * Replace all given c characters in text with given rc character
	 * @param c will be replaced character in text
	 * @param rc will be setted character to text
	 */
	public void replaceAll( char c , char rc){
		int textCursor = 0;
		while( textCursor < text.size() ){
			if ( text.get(textCursor) == c ){
				text.remove(textCursor);
				text.add(textCursor, rc);
			}
			textCursor++;
		}
	}

	/**
	 * Replace all given c characters in text with given rc character with iterator
	 * @param c will be replaced character in text
	 * @param rc will be setted character to text
	 */
	public void replaceAllIter( char c, char rc ){
		
		ListIterator<Character> listIter = text.listIterator(0);

		while( listIter.hasNext() ){
			if ( listIter.next() == c ){
				listIter.remove();
				listIter.add(rc);
			}
		}
	}
	/**
	 * Prints the text
	 */
	public String toString() {
		ListIterator<Character> listIter = text.listIterator(0);
		String str = new String();
		
		while( listIter.hasNext() ) {
			str += listIter.next();
		}
		
		return str;
	}
}
