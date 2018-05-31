package leetcode;

public class QueueReconstruction {
	public static void main(String[] args) {
		int [][] people = 
		{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
		QueueReconstruction queueReconstruction = new QueueReconstruction();
		queueReconstruction.reconstructQueue(people); 
	}
	public int[][] reconstructQueue(int[][] people) {
        int size = people.length;
        int[][] priorityQueue = bottomUpHeap(people,size);
        System.out.println(toString(people));
        System.out.println(toString(priorityQueue));
        int[][] queue = new int[people.length][2];
        for(int i=0;i<people.length;i++) {
        		queue[i]=null;
        }
        while(size>=1){
            int[] person = removeMin(priorityQueue,size);
            int i = 0;
            int value = 0;
            while(value!=person[1] ||(value == person[1] && queue[i] != null)){
                if(queue[i] == null || queue[i][0] == person[0]){
                    value++;
                }
                i++;
                if(i==queue.length){
                    break;
                }
            }
            if(i>=0 && i<queue.length){
                queue[i] = person;
            }
            size--;
        }
        System.out.println(toString(queue));
        return queue;       
    }
    public int[][] bottomUpHeap(int[][] people,int size){
        int[][] priorityQueue = new int[size+1][2];
        for(int k=1;k<=size;k++){
            priorityQueue[k] = people[k-1];
        }
        //start from last internal node 
        int i = size/2; 
        while(i>=0){
            //bubble down
            int j=i;
            while(j<=size/2){
            		if(2*j+1>size) {
            			if(priorityQueue[j][0]>priorityQueue[2*j][0]) {
            				int[] prep;
            				prep = priorityQueue[2*j]; 
                    		priorityQueue[2*j] = priorityQueue[j];
                    		priorityQueue[j] = prep;
            			}
            			break;
            		}

            		if(priorityQueue[j][0]<=priorityQueue[2*j][0] 
            				&& priorityQueue[j][0]<=priorityQueue[2*j+1][0]) {
            			break;
            		}else{
              		int[] prep;
                    if(priorityQueue[2*j][0]>=priorityQueue[2*j+1][0]) {
                    		prep = priorityQueue[2*j+1];
                    		priorityQueue[2*j+1] = priorityQueue[j];
                    		priorityQueue[j] = prep;
                    		 j=j*2+1;
                    }else {
                    		prep = priorityQueue[2*j]; 
                    		priorityQueue[2*j] = priorityQueue[j];
                    		priorityQueue[j] = prep;
                    		j=j*2;
                    }
                    
                }
               
            }
            i--;
        }
        return priorityQueue;
    }
    public int[] removeMin(int[][] priorityQueue, int size){
        int[] person = priorityQueue[1];
        priorityQueue[1] = priorityQueue[size];
        priorityQueue[size] = null;
        size = size-1;
        //bubble down
        int j = 1;
        while(j<=size/2){
        	if(2*j+1>size) {
    			if(priorityQueue[j][0]>priorityQueue[2*j][0]) {
    				int[] prep;
    				prep = priorityQueue[2*j]; 
            		priorityQueue[2*j] = priorityQueue[j];
            		priorityQueue[j] = prep;
    			}
    			break;
    		}

    		if(priorityQueue[j][0]<=priorityQueue[2*j][0] 
    				&& priorityQueue[j][0]<=priorityQueue[2*j+1][0]) {
    			break;
    		}else{
      		int[] prep;
            if(priorityQueue[2*j][0]>=priorityQueue[2*j+1][0]) {
            		prep = priorityQueue[2*j+1];
            		priorityQueue[2*j+1] = priorityQueue[j];
            		priorityQueue[j] = prep;
            		j=j*2+1;
            }else {
            		prep = priorityQueue[2*j]; 
            		priorityQueue[2*j] = priorityQueue[j];
            		priorityQueue[j] = prep;
            		j=j*2;
            }
            
        }
            
        }
        
    
        return person;
    }
    public String toString(int[][] people) {
    		String s = "[[ ";
    		for(int i=0;i<people.length;i++) {
    			s = s  + "[";
    			for(int j=0;j<people[i].length;j++) {
    				s = s + people[i][j]+" ";
    			}
    			s = s  + "]";
    		}
    		return s+"]";
    }
}
