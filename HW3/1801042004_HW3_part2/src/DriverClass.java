import cse222.hw3.part2.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.File;
import java.io.IOException;

public class DriverClass {

	
	public static void main(String[] args) throws Exception {
		/*
		ArrayList<Character> al1 = new ArrayList<Character>();
		ArrayList<Character> al2 = new ArrayList<Character>();
		*/
		LinkedList<Character> al1 = new LinkedList<>();
		LinkedList<Character> al2 = new LinkedList<>();

		SimpleTextEditor test = new SimpleTextEditor(al1);
		SimpleTextEditor testIter = new SimpleTextEditor(al2);
		Logger logger = null;
		FileHandler fileHandler = null;
		long beginTime, endTime;
		int returnedIndex;
		String wordToFind = "quick";
		String invalidWordToFind = "sasdsadsa";

		try {
			fileHandler = new FileHandler("Time.log");
		}
		catch(Exception e) {
			System.out.printf("\n %s \n", e.toString());
		}
		SimpleFormatter formatter = new SimpleFormatter();
		fileHandler.setFormatter(formatter);
		logger = Logger.getLogger("cse222.hw3.part2.SimpleTextEditor");
		logger.addHandler(fileHandler);

		File invalidFile = new File("invalidFile.txt");
		File testFile1 = new File("testFile1.txt");

		logger.info(String.format("******* TEST FOR %s *******\n", testFile1.toString()));
		System.out.printf("\n\n******* TEST FOR %s ******* \n\n", testFile1.toString());

		// read methods
		logger.info("TEST01 - readFromFile(invalidFile) method called with a file which is not exist");
		System.out.printf("\n TEST01 - readFromFile(invalidFile) method called with a file which is not exist \n");

		try {
			test.readFromFile(invalidFile);
		}
		catch(IOException e) {
			logger.info(e.toString() + "\n");
			System.out.printf("\n %s\n", e.toString());
		}

		beginTime = System.nanoTime();
		try {
			test.readFromFile(testFile1);
		}
		catch(IOException e) {
			logger.info(e.toString() + "\n");
			System.out.printf("\n%s\n", e.toString());
		}
		endTime = System.nanoTime();
		
		logger.info(String.format("TEST02 - readFromFile(%s) method called and executed in %d microseconds \n"
				,testFile1.toString(),(endTime - beginTime)/1000));
		System.out.printf("\n TEST02 - readFromFile(%s) method called with an exist file and executed in %d microseconds \n "
				,testFile1.toString(),(endTime - beginTime)/1000);
		System.out.printf("\n-----Text -----\n\n%s \n\n",test.toString());

		// read methods with iter
		logger.info("TEST03 - readFromFileItr(invalidFile) method called with a file which is not exist");
		System.out.printf("\n TEST03 - readFromFileItr(invalidFile) method called with a file which is not exist \n");

		try {
			testIter.readFromFileItr(invalidFile);
		}
		catch(IOException e) {
			logger.info(e.toString() + "\n");
			System.out.printf("\n %s\n", e.toString());
		}

		beginTime = System.nanoTime();
		try {
			testIter.readFromFileItr(testFile1);
		}
		catch(IOException e) {
			logger.info(e.toString() + "\n");
			System.out.printf("\n%s\n", e.toString());
		}
		endTime = System.nanoTime();

		logger.info(String.format("TEST04 - readFromFileItr(%s) method called and executed in %d microsecond.\n"
		,testFile1,(endTime - beginTime)/1000));
		System.out.printf("\nTEST04 - readFromFileItr(%s) method called and executed in %d microsecond"
				,testFile1.toString(),(endTime - beginTime)/1000);
		System.out.printf("\n-----Text -----\n\n%s \n\n",testIter.toString());

		// add methods
		System.out.printf("TEST05 - addStringToText(test.size()+5, *TEST*) method called with invalid index");
		logger.info("TEST05 - addStringToText(test.size()+5, *TEST*) method called with invalid index");
		try {
			test.addStringToText(test.size() + 5, "*TEST*");
		}
		catch ( IndexOutOfBoundsException e){
			logger.info(e.toString() + "\n");
			System.out.printf("\n%s\n", e.toString());
		}
		System.out.printf("\n-----Text -----\n\n%s \n\n",test.toString());


		beginTime = System.nanoTime();
		test.addStringToText(test.size() -5, "*TEST*");
		endTime = System.nanoTime();
		logger.info(String.format("TEST06 - addStringToText(test.size()-5, *TEST*) method called and executed in %d microsecond \n"
				,(endTime - beginTime)/1000));
		System.out.printf("TEST06 - addStringToText(test.size()-5, *TEST*) method called and executed in %d microseconds\n "
				,(endTime - beginTime)/1000);

		System.out.printf("\n-----Text -----\n\n%s \n\n",test.toString());

		// add methods with iter

		System.out.printf("TEST07 - addStringToTextItr(test.size()+5, *TEST*) method called with invalid index");
		logger.info("TEST07 - addStringToTextItr(test.size()+5, *TEST*) method called with invalid index");
		try {
			testIter.addStringToText(testIter.size() + 5, "*TEST*");
		}
		catch ( IndexOutOfBoundsException e){
			logger.info(e.toString() + "\n");
			System.out.printf("\n%s\n", e.toString());
		}
		System.out.printf("\n-----Text -----\n\n%s \n\n",testIter.toString());

		beginTime = System.nanoTime();
		testIter.addStringToTextItr(testIter.size()-5, "*TEST*");
		endTime = System.nanoTime();
		logger.info(String.format("TEST08 - addStringToTextItr(test.size()-5, *TEST*) method called and executed in %d microseconds"
				,(endTime - beginTime)/1000));
		System.out.printf("TEST08 - addStringToTextItr(test.size()-5, *TEST*) method called and executed in %d microseconds"
				,(endTime - beginTime)/1000);
		System.out.printf("\n-----Text -----\n\n %s \n\n",testIter.toString());

		// find methods
		System.out.printf("\n-----Text -----\n\n%s \n\n",test.toString());
		System.out.printf("\n TEST09 - findStringInText(%s) method called with invalid word returnedIndex : -1\n ",invalidWordToFind);
		logger.info(String.format("TEST09 - findStringInText(%s) method called with invalid word returnedIndex : -1\n ",invalidWordToFind));
		if( test.findStringInText(invalidWordToFind) == - 1 ){
			System.out.printf("\n Given word (%s) is not find in text\n ",invalidWordToFind);
			logger.info(String.format("Given word (%s) is not find in text\n ",invalidWordToFind));
		}

		System.out.printf("\n-----Text -----\n\n%s \n\n",test.toString());
		beginTime = System.nanoTime();
		returnedIndex = test.findStringInText(wordToFind);
		endTime = System.nanoTime();
		logger.info(String.format("TEST10 - findStringInText(%s) method called and executed in %d microseconds returnedIndex: %d "
				,wordToFind,(endTime - beginTime)/1000, returnedIndex));
		System.out.printf("\n TEST10 - findStringInText(%s) method called and executed in %d microseconds returnedIndex: %d\n "
				,wordToFind,(endTime - beginTime)/1000, returnedIndex);

		// find methods with iter
		System.out.printf("\n-----Text -----\n\n%s \n\n",testIter.toString());
		System.out.printf("\n TEST11 - findStringInTextItr(%s) method called with invalid word returnedIndex : -1\n ",invalidWordToFind);
		logger.info(String.format("TEST11 - findStringInTextItr(%s) method called with invalid word returnedIndex : -1\n ",invalidWordToFind));
		if( testIter.findStringInTextItr(invalidWordToFind) == - 1 ){
			System.out.printf("\n Given word (%s) is not find in text\n ",invalidWordToFind);
			logger.info(String.format("Given word (%s) is not find in text\n ",invalidWordToFind));
		}

		System.out.printf("\n-----Text -----\n\n%s \n\n",testIter.toString());
		beginTime = System.nanoTime();
		returnedIndex = testIter.findStringInTextItr(wordToFind);
		endTime = System.nanoTime();
		logger.info(String.format("TEST12 - findStringInText(%s) method called and executed in %d microseconds returnedIndex: %d  \n" 
				,wordToFind,(endTime - beginTime)/1000, returnedIndex));
		System.out.printf("\n TEST12 - findStringInText(%s) method called and executed in %d microseconds returnedIndex: %d \n " 
				,wordToFind,(endTime - beginTime)/1000, returnedIndex);

		//replace method
		System.out.printf("\n-----Text -----\n\n%s \n\n",test.toString());
		beginTime = System.nanoTime();
		test.replaceAll('a', '-');
		endTime = System.nanoTime();
		logger.info(String.format("TEST13 - replaceAll(a,-) method called and executed in %d microseconds"
				,(endTime - beginTime)/1000));
		System.out.printf("TEST13 - replaceAll(a,-) method called and executed in %d microseconds"
				,(endTime - beginTime)/1000);
		System.out.printf("\n-----Text -----\n\n%s \n\n",test.toString());

		// replace method with iter
		System.out.printf("\n-----Text -----\n\n%s \n\n",testIter.toString());
		beginTime = System.nanoTime();
		testIter.replaceAllIter('a', '-');
		endTime = System.nanoTime();
		logger.info(String.format("TEST14 - replaceAllItr(a,-) method called and executed in microseconds%d "
				,(endTime - beginTime)/1000));
		System.out.printf("TEST14 - replaceAllItr(a,-) method called and executed in %d microseconds\n"
				,(endTime - beginTime)/1000);
		System.out.printf("\n-----Text -----\n\n%s \n\n",testIter.toString());


	}
	


}