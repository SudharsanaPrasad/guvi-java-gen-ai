package com.guvi.exceptions.checked;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        // try/catch block - allows us to handle the exception
        readFile();
    }

    public static boolean readFile() {
        FileReader reader = null;
        try {
            reader = new FileReader("/path/to/random.txt");
            reader.read();
            // parse the content of the file to an integer - "Nikhil"

            // another code block that throws NullPointerException
        } catch(FileNotFoundException exception) {
            System.out.println("FileNotFoundException " + exception.getMessage());
            exception.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            //throw new IOException("IO Exception");
            return false;
        } catch(Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            //reader.close();
        }
        return true;
    }

    /*
        public static void main(String[] args) throws FileNotFoundException {
               FileReader reader = new FileReader("/path/to/random.txt");
        }
    */
}
