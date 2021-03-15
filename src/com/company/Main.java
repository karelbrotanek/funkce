package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static class Funkce {
        private String f;
        public Funkce(String s){
            f = s;
        }
        public void setF(String s){
            f = s;
        }
        public String getF (){
            return f;
        }
        public String toString(){
            return f;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("functions.txt"));
        String line;
        ArrayList<Funkce> funkce = new ArrayList<Funkce>();
        while ((line = br.readLine()) != null){
            funkce.add(new Funkce(line));
        }
        for (int i = 0; i < funkce.size(); i++) {
            System.out.println(funkce.get(i).toString());
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("count.txt"));
        bw.write(Integer.toString(funkce.size()));
        bw.flush();
        bw.close();
        System.out.println(funkce.size());
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("count_distinct.txt"));
        int pocetunikatnich = 1;
        boolean nova = true;
        for (int i = 1; i < funkce.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (funkce.get(i).getF().equals(funkce.get(j))){
                    nova = false;
                    j = i;
                }
            }
            if (nova){
                pocetunikatnich++;
            }
        }
        bw2.write(Integer.toString(pocetunikatnich));
        bw2.flush();
        bw2.close();
    }
}
