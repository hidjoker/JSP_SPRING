package test;

public class test2 {
	
	public int[] solution(int N, int[] stages) {
       	
	    	//값 넣어주기
	    	int[] arr1 = new int[N];
	    	int index = 0;
	    	
	    	if(N>=stages.length) {
	    		for(int i=1 ; i<=N+1 ; i++) {
	    			for(int q=0; q<stages.length ; q++) {
	    				if(i==stages[q]) {
	    					if(i>N) {
	    						arr1[index] = N;
	    					}else {
	    						arr1[index] =i;
	    					}
	    					index++;
	    					break;
	    				}
	    			}
	    		}
	    	}else {
	    		for(int i=1 ; i<N+1 ; i++){
	    			arr1[i-1] = i;
	    		}
	    		
	    	}
	    	
			for (int i : arr1) {
				System.out.println("arr1:"+i);
			}
	    	
	    	int count = 0;
	    	int total = 0;
	    	double[] arr2 = new double[N];
	    	//실패횟수 계산
	    	for(int i=0; i < arr1.length ; i++) {   				
	    		for(int q=0 ; q < stages.length ; q++) {
	    			if(arr1[i] <= stages[q])
	    				total++;  			
	    		}
	    		for(int q=0 ; q < stages.length ; q++) {
	    			if(arr1[i] == stages[q]) {
	    				count++;
	    			}   			
	    		}
	    		arr2[i] = (double) count / total;
	    		count=0;  		
	    		total=0;
	    	}
	    	
			for (double i : arr2) {
				System.out.println("arr2:"+i);
			}
	    	
	    	//결과 담기
	        int rank = 0;   
	    	int[] answer = new int[N];
	    	
	    	for(int i=0 ; i<arr2.length ; i++) {
	    		for(int q=0 ; q<arr2.length ; q++) {
	    			if(i==q)continue;
	    			if(arr2[i]==arr2[q]) {
	    				if(i>q)rank++; 
	    			}else if(arr2[i] < arr2[q]) {
	    				rank++;
	    			}
	    		}
	    		answer[rank] = arr1[i];
	    		rank=0;
	    	}    
	    	
	        return answer;
	}
}