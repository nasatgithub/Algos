package com.nasir.trees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by nasir on 12/15/16.
 */
public class FindAllPaths {
    public static Character source, dest;

    public static void main(String args[]) {
        source = dest = null;
        try {
            HashMap<Character, List<Character>> adjMap = convertFileToMap();
            for(Character c: adjMap.keySet()) {
                System.out.println(c + " ->" + adjMap.get(c));
            }

            if(source!=null && dest!=null && !adjMap.isEmpty()) {
                printAllPaths(adjMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<Character, List<Character>> convertFileToMap() throws IOException {


        FileReader fr = new FileReader("/home/nasir/Graph.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        List<String> fileLines = new ArrayList<>();
        while((line = br.readLine())!=null) {
            System.out.println(line);
            fileLines.add(line);
        }

        return convertLinesToMap(fileLines);
    }

    public static HashMap<Character, List<Character>>  convertLinesToMap(List<String> fileLines){
        HashMap<Character, List<Character>> adjMap = new HashMap<>();

        String[] firstLineSplits = fileLines.get(0). split(" ");
        source = firstLineSplits[0].charAt(0);
        dest = firstLineSplits[1].charAt(0);

        for(int i=1; i<fileLines.size(); i++) {
             String[] lineSplits = fileLines.get(i).trim().split(":");
             String[] adjSplits = lineSplits[1].trim().split(" ");
             List<Character> adjSplitList = new ArrayList<>();
             for(String adjSplit: adjSplits) {
                    adjSplitList.add(adjSplit.trim().charAt(0));
             }
             adjMap.put(lineSplits[0].trim().charAt(0), adjSplitList);
        }

        return  adjMap;
    }


    public static void printAllPaths(HashMap<Character, List<Character>> adjMap) {
        HashSet<Character> visitedNodes = new HashSet<Character>();
        visitedNodes.add(source);
        depthFirstSearch(source,adjMap, visitedNodes, new StringBuffer(String.valueOf(source)));
    }



    public  static void depthFirstSearch(Character currentNode, HashMap<Character, List<Character>> adjMap, HashSet<Character> visitedNodes, StringBuffer currentPath){

        if(!adjMap.containsKey(currentNode))
            return;

        for(Character node: adjMap.get(currentNode)) {
            StringBuffer newCurrentPath = new StringBuffer(currentPath);
            newCurrentPath.append(node);
            if(node == dest) {
                System.out.println(newCurrentPath);
                continue;
            }
            else if(!visitedNodes.contains(node)) {
                visitedNodes.add(node);
                depthFirstSearch(node, adjMap, visitedNodes, newCurrentPath);
            }
        }
    }

}
