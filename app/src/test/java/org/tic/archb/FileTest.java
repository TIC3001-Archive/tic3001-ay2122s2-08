/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.tic.archb;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FileTest {
    @Test public void ReadTitleFile() {
        String inputFile = "../../tic3001-ay2122s2-08/Assignment2Testcases/Test3/Titles3.txt";
        List<String> list = new ArrayList<>(Arrays.asList("Back to the Future", "Desperado", "Night at the Museum",
                "Robocop", "Ghostbusters", "Cool World", "donnie Darko", "Double Indemnity"));

        FileReader readInputFile = new FileReader(inputFile);
        Words titles = new Words();
        readInputFile.populateWords(titles);
        assertEquals(list,titles.getWords());
    }

    @Test public void ReadIgnoreFile() {
        String inputFile = "../../tic3001-ay2122s2-08/Assignment2Testcases/Test3/Ignored3.txt";
        List<String> list = new ArrayList<>(Arrays.asList("cool" , "a" , "the" , "to" , "donniE"));

        FileReader readIgnoreFile = new FileReader(inputFile);
        Words ignored = new Words();
        readIgnoreFile.populateWords(ignored);
        assertEquals(list,ignored.getWords());
    }

    @Test public void ReadRequiredFile() {
        String inputFile = "../../tic3001-ay2122s2-08/Assignment2Testcases/Test3/Required3.txt";
        List<String> list = new ArrayList<>(Arrays.asList("world" , "ghost" , "robocop"));

        FileReader readRequiredFile = new FileReader(inputFile);
        Words required = new Words();
        readRequiredFile.populateWords(required);
        assertEquals(list,required.getWords());
    }

    @Test public void ReadEmptyFile() {
        String inputFile = "../../tic3001-ay2122s2-08/Assignment2Testcases/Test2/Required2.txt";
        List<String> list = new ArrayList<>();

        FileReader readInputFile = new FileReader(inputFile);
        Words titles = new Words();
        readInputFile.populateWords(titles);
        assertEquals(list,titles.getWords());
    }

    private Words getFiles(String inputFile) {

        // Read main file
        FileReader readInputFile = new FileReader(inputFile);
        Words ListOfFiles = new Words();
        readInputFile.populateWords(ListOfFiles);
        return ListOfFiles;
    }

    private ByteArrayOutputStream getByteArrayOutputStream(ByteArrayOutputStream outContent, List<String> searchedWords, String computer, Words ListOfFiles, List<String> ignoredWords) {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        searchedWords.add(computer);          //If new word, then add to list
        for (String file : ListOfFiles.getWords()) {
            Master abstractDateType = new Master();
            abstractDateType.Search(file, ignoredWords, searchedWords); //Search on all inserted word
        }
        return outContent;
    }

    //Standard
    @Test public void Assignment3Test1() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        Words ListOfFiles = getFiles("../../tic3001-ay2122s2-08/Assignment3Testcases/Test1/ListOfFiles.txt");

        List<String> searchedWords = new ArrayList<>();
        List<String> ignoredWords = new ArrayList<>();

        outContent = getByteArrayOutputStream(outContent, searchedWords, "science", ListOfFiles, ignoredWords);


        //Test "Science"
        assertEquals("CourseTitles.txt\n" +
                "Science Life \n" +
                "science Computer \n", outContent.toString());

        outContent = getByteArrayOutputStream(outContent, searchedWords, "computer", ListOfFiles, ignoredWords);

        //Test "computer"
        assertEquals("CourseTitles.txt\n" +
                "Computer science \n" +
                "Science Life \n" +
                "science Computer \n" +
                "MovieTitles.txt\n" +
                "Computer chess \n", outContent.toString());

        outContent = getByteArrayOutputStream(outContent, searchedWords, "happy", ListOfFiles, ignoredWords);

        //Test "happy"
        assertEquals("CourseTitles.txt\n" +
                "Computer science \n" +
                "Science Life \n" +
                "science Computer \n" +
                "MovieTitles.txt\n" +
                "Computer chess \n", outContent.toString());

        outContent = getByteArrayOutputStream(outContent, searchedWords, "multi word", ListOfFiles, ignoredWords);

        //Test "multi word"
        assertEquals("CourseTitles.txt\n" +
                "Computer science \n" +
                "Science Life \n" +
                "science Computer \n" +
                "MovieTitles.txt\n" +
                "Computer chess \n", outContent.toString());

    }

    //No files
    @Test public void Assignment3Test2() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        Words ListOfFiles = getFiles("../../tic3001-ay2122s2-08/Assignment3Testcases/Test2/ListOfFiles.txt");

        List<String> searchedWords = new ArrayList<>();
        List<String> ignoredWords = new ArrayList<>();

        //Test "Science"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "science", ListOfFiles, ignoredWords);
        assertEquals("", outContent.toString());

        //Test "computer"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "computer", ListOfFiles, ignoredWords);
        assertEquals("", outContent.toString());

        //Test "happy"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "happy", ListOfFiles, ignoredWords);
        assertEquals("", outContent.toString());

        outContent = getByteArrayOutputStream(outContent, searchedWords, "multi word", ListOfFiles, ignoredWords);
        assertEquals("", outContent.toString());
    }

    //No content in file
    @Test public void Assignment3Test3() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        Words ListOfFiles = getFiles("../../tic3001-ay2122s2-08/Assignment3Testcases/Test3/ListOfFiles.txt");

        List<String> searchedWords = new ArrayList<>();
        List<String> ignoredWords = new ArrayList<>();

        //Test "Science"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "science", ListOfFiles, ignoredWords);
        assertEquals("", outContent.toString());

        //Test "computer"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "computer", ListOfFiles, ignoredWords);
        assertEquals("", outContent.toString());

        //Test "happy"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "happy", ListOfFiles, ignoredWords);
        assertEquals("", outContent.toString());

        outContent = getByteArrayOutputStream(outContent, searchedWords, "multi word", ListOfFiles, ignoredWords);
        assertEquals("", outContent.toString());
    }

    //Repeated words
    @Test public void Assignment3Test4() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        Words ListOfFiles = getFiles("../../tic3001-ay2122s2-08/Assignment3Testcases/Test4/ListOfFiles.txt");

        List<String> searchedWords = new ArrayList<>();
        List<String> ignoredWords = new ArrayList<>();

        //Test "Science"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "science", ListOfFiles, ignoredWords);
        assertEquals("CourseTitles.txt\n" +
                "science science \n" +
                "science science \n" +
                "science science \n" +
                "science science \n" +
                "MovieTitles.txt\n" +
                "Science science \n" +
                "science Science \n" +
                "science science \n" +
                "science science \n", outContent.toString());

        //Test "computer"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "computer", ListOfFiles, ignoredWords);
        assertEquals("CourseTitles.txt\n" +
                "science science \n" +
                "science science \n" +
                "science science \n" +
                "science science \n" +
                "MovieTitles.txt\n" +
                "Science science \n" +
                "science Science \n" +
                "science science \n" +
                "science science \n", outContent.toString());

        //Test "happy"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "happy", ListOfFiles, ignoredWords);
        assertEquals("CourseTitles.txt\n" +
                "science science \n" +
                "science science \n" +
                "science science \n" +
                "science science \n" +
                "MovieTitles.txt\n" +
                "Science science \n" +
                "science Science \n" +
                "science science \n" +
                "science science \n", outContent.toString());

        outContent = getByteArrayOutputStream(outContent, searchedWords, "multi word", ListOfFiles, ignoredWords);
        assertEquals("CourseTitles.txt\n" +
                "science science \n" +
                "science science \n" +
                "science science \n" +
                "science science \n" +
                "MovieTitles.txt\n" +
                "Science science \n" +
                "science Science \n" +
                "science science \n" +
                "science science \n", outContent.toString());
    }

    //More files
    @Test public void Assignment3Test5() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        Words ListOfFiles = getFiles("../../tic3001-ay2122s2-08/Assignment3Testcases/Test5/ListOfFiles.txt");

        List<String> searchedWords = new ArrayList<>();
        List<String> ignoredWords = new ArrayList<>();

        //Test "Science"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "science", ListOfFiles, ignoredWords);
        assertEquals("CourseTitles.txt\n" +
                "Science Life \n" +
                "science Computer \n" +
                "BookTitles.txt\n" +
                "Science in the backyard \n" +
                "SongTitles.txt\n" +
                "Science She Blinded Me With \n", outContent.toString());

        //Test "computer"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "computer", ListOfFiles, ignoredWords);
        assertEquals("CourseTitles.txt\n" +
                "Computer science \n" +
                "Science Life \n" +
                "science Computer \n" +
                "MovieTitles.txt\n" +
                "Computer chess \n" +
                "BookTitles.txt\n" +
                "Science in the backyard \n" +
                "SongTitles.txt\n" +
                "Computer geek \n" +
                "Science She Blinded Me With \n", outContent.toString());

        //Test "happy"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "happy", ListOfFiles, ignoredWords);
        assertEquals("CourseTitles.txt\n" +
                "Computer science \n" +
                "Science Life \n" +
                "science Computer \n" +
                "MovieTitles.txt\n" +
                "Computer chess \n" +
                "BookTitles.txt\n" +
                "Science in the backyard \n" +
                "SongTitles.txt\n" +
                "Computer geek \n" +
                "Happy together \n" +
                "Science She Blinded Me With \n", outContent.toString());

        //Test "multi word"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "multi word", ListOfFiles, ignoredWords);
        assertEquals("CourseTitles.txt\n" +
                "Computer science \n" +
                "Science Life \n" +
                "science Computer \n" +
                "MovieTitles.txt\n" +
                "Computer chess \n" +
                "BookTitles.txt\n" +
                "Science in the backyard \n" +
                "SongTitles.txt\n" +
                "Computer geek \n" +
                "Happy together \n" +
                "Science She Blinded Me With \n", outContent.toString());
    }

    //Paragraph
    @Test public void Assignment3Test6() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        Words ListOfFiles = getFiles("../../tic3001-ay2122s2-08/Assignment3Testcases/Test6/ListOfFiles.txt");

        List<String> searchedWords = new ArrayList<>();
        List<String> ignoredWords = new ArrayList<>();

        //Test "Science"
        outContent = getByteArrayOutputStream(outContent, searchedWords, "repudiated", ListOfFiles, ignoredWords);
        assertEquals("TitlesInput.txt\n" +
                "repudiated and annoyances accepted The wise man therefore always holds in these matters to this principle of selection he rejects pleasures to secure other greater pleasures or else he endures pains to avoid worse pains On the other hand we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment so blinded by desire that they cannot foresee the pain and trouble that are bound to ensue and equal blame belongs to those who fail in their duty through weakness of will which is the same as saying through shrinking from toil and pain These cases are perfectly simple and easy to distinguish In a free hour when our power of choice is untrammelled and when nothing prevents our being able to do what we like best every pleasure is to be welcomed and every pain avoided But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be \n",
                outContent.toString());


        outContent = getByteArrayOutputStream(outContent, searchedWords, "pleasures", ListOfFiles, ignoredWords);
        assertEquals("TitlesInput.txt\n" +
                "pleasures have to be repudiated and annoyances accepted The wise man therefore always holds in these matters to this principle of selection he rejects pleasures to secure other greater pleasures or else he endures pains to avoid worse pains On the other hand we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment so blinded by desire that they cannot foresee the pain and trouble that are bound to ensue and equal blame belongs to those who fail in their duty through weakness of will which is the same as saying through shrinking from toil and pain These cases are perfectly simple and easy to distinguish In a free hour when our power of choice is untrammelled and when nothing prevents our being able to do what we like best every pleasure is to be welcomed and every pain avoided But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that \n" +
                "pleasures or else he endures pains to avoid worse pains On the other hand we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment so blinded by desire that they cannot foresee the pain and trouble that are bound to ensue and equal blame belongs to those who fail in their duty through weakness of will which is the same as saying through shrinking from toil and pain These cases are perfectly simple and easy to distinguish In a free hour when our power of choice is untrammelled and when nothing prevents our being able to do what we like best every pleasure is to be welcomed and every pain avoided But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted The wise man therefore always holds in these matters to this principle of selection he rejects pleasures to secure other greater \n" +
                "pleasures to secure other greater pleasures or else he endures pains to avoid worse pains On the other hand we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment so blinded by desire that they cannot foresee the pain and trouble that are bound to ensue and equal blame belongs to those who fail in their duty through weakness of will which is the same as saying through shrinking from toil and pain These cases are perfectly simple and easy to distinguish In a free hour when our power of choice is untrammelled and when nothing prevents our being able to do what we like best every pleasure is to be welcomed and every pain avoided But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted The wise man therefore always holds in these matters to this principle of selection he rejects \n" +
                "repudiated and annoyances accepted The wise man therefore always holds in these matters to this principle of selection he rejects pleasures to secure other greater pleasures or else he endures pains to avoid worse pains On the other hand we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment so blinded by desire that they cannot foresee the pain and trouble that are bound to ensue and equal blame belongs to those who fail in their duty through weakness of will which is the same as saying through shrinking from toil and pain These cases are perfectly simple and easy to distinguish In a free hour when our power of choice is untrammelled and when nothing prevents our being able to do what we like best every pleasure is to be welcomed and every pain avoided But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be \n",
                outContent.toString());
    }

}
