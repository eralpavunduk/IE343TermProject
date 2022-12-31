package questions;

import java.io.BufferedReader;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class main {
  
	
	   public static void main(String[] args) throws IOException
	   {
		   
		    
            List<List<String>> list = readValues();
           System.out.println(list.get(0));
	List<Integer> valueList = new ArrayList<Integer>();
	List<Integer> weightList = new ArrayList<Integer>();
	
	
	 
	for(int i=1;i<list.size();i++) {
		valueList.add(Integer.parseInt(list.get(i).get(4))); 
		weightList.add(Integer.parseInt(list.get(i).get(5)));
		
		
	}
	List<List<String>> list1 = readSequential();
	List<ArrayList<Double>> sequential_data = new ArrayList<ArrayList<Double>>();
	for (int i=1;i<list1.size();i++){
		ArrayList<Double> row = new ArrayList<>();
		for (int j=1;j<list1.get(0).size();j++){
			row.add(Double.parseDouble(list1.get(i).get(j)));
		}
		sequential_data.add(row);
	}
	
	
	 int duration[] = new int[weightList.size()];
	
		for(int i= 0; i<duration.length; i++) {
			duration[i]= weightList.get(i);
			
		
			 
			}
		
	
		 int value[] = new int[valueList.size()];
			
			for(int i= 0; i<value.length; i++) {
				value[i]= valueList.get(i);
				
			
				 
				}
	    int capacity = 1800000;
	    
	     System.out.println();
	
	     int[][] keep = new int[51][(capacity+1)];
         double maxGain = knapsack(duration, value, capacity, keep);
         System.out.println(maxGain);
  
         
         int max =0;
         int secmax=0;
        int  countmax=0;
        int countsecmax=0;
    	 int songs[] = new int[valueList.size()];
			
			for(int i= 0; i<songs.length; i++) {
				
				songs[i]= valueList.get(i);
	         
			}
			  for(int j=0; j<50; j++) {
			      
		             if (songs[j] > max) {
		            	 
		            	 
		                 max = songs[j];
		                 countmax=j;
		                 
		             }
		        		 
		      	        }
			  songs[countmax]=0;
			  for(int j=0; j<50; j++) {
			      
		             if (songs[j] > secmax) {
		            	 
		            	 
		                 secmax = songs[j];
		                 countsecmax=j;
		                 
		             }
		        		 
		      	        }
			  
			  
			  
			System.out.println(max+ " "+ countmax + " ");
			System.out.println(secmax+ " "+countsecmax);
		
		  
		    double maks=0;
		    int countmaks=0;
	     
		    double matriks[][]=new double[50][50];
		    int[]yol= new int[50];
		    double[] dummy=new double[50];
		    double dummy2=0;
		    for(int i=0; i<50; i++) {
		    	for(int j=0; j<50; j++) {
		    		matriks[i][j]=sequential_data.get(i).get(j);
		    		
		    	}
		    	
		    
		    }
	      
	        
	        	 for(int j=0; j<50; j++) {
	        		 for(int k=0; k<50; k++) {
	        			 
	        			  if (matriks[j][k] > maks) {
	 		            	 
	 		                 maks = matriks[j][k];
	 		                 countmaks=k;
	 		               
	 		             }
	       
	        		 }
	        		 if(j+1==50) {
	        			 break;
	        		 }
	        		 dummy=matriks[j+1];
	        		 matriks[j+1]=matriks[countmaks];
	        		 matriks[countmaks]=dummy;
	        		 yol[j]=countmaks;
	        		 for(int b=0; b<50; b++) {
	        			 
	        				dummy2= matriks[b][j+1];
	        				matriks[b][j+1]=matriks[b][countmaks];
	        				matriks[b][countmaks]=dummy2;
	        				
	        				
	        			 
	        		 }
	        		 for(int a =0; a<50; a++) {
	        			 matriks[a][j]=0;
	        			 matriks[j][a]=0;
	        			 
	        		 }
	        		 
	        	     maks=0;
	        	     countmaks=0;
	        		 
	        	 }	
	        	  yol[0]=countmax;
	  	          yol[49]=countsecmax;
	         
	         
	         for(int i=0; i<50; i++) {
	        	 System.out.print(yol[i]+ " ");
	         }
         }
	   
	   private static double knapsack(int[] w, int[] v, int W, int[][] keep) {
           int[][] matrix = new int[w.length + 1][W + 1];
           int[] solution = new int[w.length+1];
           for (int i = 0; i < w.length; i++) {
               for (int j = 0; j < W; j++) {
                   matrix[i][j] = 0;
               }
           }
      
           for (int i = 1; i <= w.length; i++) {
               for (int j = 0; j <= W; j++) {
                   int weight = w[i - 1];
                   if(weight<=j){
                       matrix[i][j] = Math.max(
                               v[i - 1] + matrix[i - 1][j - weight],
                               matrix[i - 1][j] );
                       keep[i][j] = 1;
                       
                 
                   }else{
                       matrix[i][j]=matrix[i-1][j];
                       keep[i][j] = 0;
                       
                   }
   
               }
           }
           int K = W;
           double sumweight = 0;
           double valueofalbum = 0;
           for (int i=w.length;i>=0;i--){
                   if(keep[i][K] == 1){
                           solution[i] = 1;
                           System.out.print(i+" ");
                           K -= w[i-1];
                           sumweight = sumweight + w[i-1];
                   }
           }

           valueofalbum = (sumweight/1000)*0.02;
           System.out.println();
           return matrix[w.length][W]-valueofalbum;
           
        
           
       }        

	    
	   
  public static List<List<String>> readValues() throws IOException { 
           try
	{
		List< List<String> > data = new ArrayList<>();//list of lists to store data
		String file = "term_project_value_data.csv";//file path
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		//Reading until we run out of lines
		String line = br.readLine();
		while(line != null)
		{
			List<String> lineData = Arrays.asList(line.split(","));//splitting lines
			data.add(lineData);
			line = br.readLine();
		}
		
		//printing the fetched data
		for(List<String> list : data)
		{
			for(String str : list)
				System.out.print(str + " ");
			System.out.println();
		}
		br.close();
                   return data;
	}
	catch(Exception e)
	{
		System.out.print(e);
                   List< List<String> > data = new ArrayList<>();//list of lists to store data
                   return data;
	}
           
   }
    public static List<List<String>> readSequential() throws IOException { 
           try
	{
		List< List<String> > data = new ArrayList<>();//list of lists to store data
		String file = "term_project_sequential_data.csv";//file path
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		//Reading until we run out of lines
		String line = br.readLine();
		while(line != null)
		{
			List<String> lineData = Arrays.asList(line.split(","));//splitting lines
			data.add(lineData);
			line = br.readLine();
		}
		
		//printing the fetched data
		for(List<String> list : data)
		{
			for(String str : list)
				System.out.print(str + " ");
			System.out.println();
		}
		br.close();
                   return data;
	}
	catch(Exception e)
	{
		System.out.print(e);
                  List< List<String> > data = new ArrayList<>();//list of lists to store data
                   return data;
	}
           
   }
	
	
	
	
	
}


