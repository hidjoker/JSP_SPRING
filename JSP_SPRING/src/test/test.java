package test;

public class test {
    
	public String[] solution(String[] record) {
        
        int length = record.length;
        System.out.println(length);
        //Enter와 Change적용하기
        for( int i=0 ; i<record.length ; i++){
            
            String[] arr1 = record[i].split(" ");
                   
            if(arr1[0].equals("Enter")){
                for(int q = 0 ; q<=i ; q++){
                    String[] arr2 = record[q].split(" ");
                    if(arr1[1].equals(arr2[1])){
                        record[q] =arr2[0]+" "+arr2[1]+" "+arr1[2];
                    }
                }                
            }
            if(arr1[0].equals("Change")) {
                length --;
                for(int q = 0 ; q<=i ; q++){             
                	String[] arr2 = record[q].split(" ");          
                    if(arr1[1].equals(arr2[1])){
                        record[q] =arr2[0]+" "+arr2[1]+" "+arr1[2];
                    }
                }  
            }
        }
        
        //결과 문자열 담기

        String[] answer = new String[length];
        System.out.println(length);
        int index = 0;
        for( int i=0 ; i<record.length ; i++){
            
        	String[] arr1 = record[i].split(" ");        
        	
            if(arr1[0].equals("Enter")){          	
            	System.out.println(index);
            	answer[index] = arr1[2]+"님이 들어왔습니다";	
            	index++;
            }else if(arr1[0].equals("Leave")) {
            	answer[index] = arr1[2]+"님이 나갔습니다";
            	index++;
            }
            
        }
        return answer;

	}
}
