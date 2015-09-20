package com.mj.algo.clustering;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * Clustering using Union-Find approach
 */
public class Clustering {

	private static int[] parents;

	static class Edge implements Comparable<Edge> {

		private int i;
		private int j;
		private int cost;

		public Edge(int i, int j, int cost) {
			this.i = i;
			this.j = j;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge arg0) {
			if (this.cost >= arg0.cost)
				return 1;
			else
				return -1;
			// return 0;
		}

	}

	private static int find(int i) {
		while (parents[i] > 0) {
			i = parents[i];
		}
		return i;
	}

	public static void union(int i, int j) {
		// find parents of i and j..if same..they r in same cluster, update the
		// count
		// el rent to the other parent

		int pi = find(i);
		int pj = find(j);

		if (pi == pj)
			parents[pi] += -1;
		else {
			if (parents[pi] < parents[pj]) {
				// -ve counts so actually pi is larger than pj
				parents[pi] += parents[pj];
				parents[pj] = pi;
			} else {
				parents[pj] += parents[pi];
				parents[pi] = pj;
			}
		}
	}

	public static int numClusters() {
		// num of -ve entries in parents is the no of clusters
		int c = 0;
		for (int i = 0; i < parents.length; i++)
			if (parents[i] < 0)
				c++;
		return c;
	}
	
	 /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        ArrayList<Edge> edges = new ArrayList<Edge>();  
        ArrayList<ArrayList<Integer>> clusters = new ArrayList<ArrayList<Integer>>();  
        int k = 4;  
        int n = 0;  
        try {  
            FileInputStream f = new FileInputStream("clustering1.txt");  
            DataInputStream d = new DataInputStream(f);  
            BufferedReader b =  new BufferedReader(new InputStreamReader(d));  
            n = Integer.parseInt(b.readLine());  
            parents = new int[n];             
  
            for(int i = 0; i < n;i++){  
                parents[i] = -1;                  
            }  
            String str; int i,j,v;  
            while((str=b.readLine())!=null){  
                i = Integer.parseInt(str.split(" ")[0]);  
                j = Integer.parseInt(str.split(" ")[1]);  
                v = Integer.parseInt(str.split(" ")[2]);  
                edges.add(new Edge(i-1,j-1,v));  
            }  
            Collections.sort(edges);  
            for(Edge e : edges){  
                union(e.i,e.j);  
                if (numClusters()==k) {  
                    System.out.println("k clusters found ");  
                    break;                
                }  
            }  
            //print the max distance among clusters..is actuallz the min distance between any two clusters  
            int max = Integer.MAX_VALUE;  
            for (Edge e : edges){  
                if (find(e.i)!=find(e.j)) max=Math.min(max, e.cost);                  
            }  
            System.out.println("max distance "+max);  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (NumberFormatException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }     
  
    }  

}
