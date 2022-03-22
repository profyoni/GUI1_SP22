package edu.touro.cs.mcon364;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class _21_GsonTester2 {
        public static void main(String args[]) {

            _21_GsonTester2 tester = new _21_GsonTester2();
            try {
                Student student = new Student();
                student.setAge(10);
                student.setName("Mahesh");
                tester.writeJSON(student);
                Student student1 = tester.readJSON();
                System.out.println(student1);
            }
            catch(FileNotFoundException e) {
                e.printStackTrace();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }

        private void writeJSON(Student student) throws IOException {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            FileWriter writer = new FileWriter("student.json");
            writer.write(gson.toJson(student));
            writer.close();
        }

        private Student readJSON() throws FileNotFoundException {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("student.json"));

            Student student = gson.fromJson(bufferedReader, Student.class);
            return student;
        }
    }

