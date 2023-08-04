
package stackapplet;


public class StackClass {
    int[] array;
    int top;
    int size;

    public StackClass(int size) {
        this.size=size;
        this.array=new int[size];
        this.top=-1;
    }
    
    public boolean isFull(){
        if(top==this.size-1){
            return true;}
        else{
            return false;}
                           }
    public boolean isEmpty(){
        if(top==-1){
            return true;}
        else{
            return false;}
                          }
    public int pop(){
        if(top!=-1){
          return array[top--];  
        }
        else{
            return -1;
        }
    }
    public void push(int key){
        if(!isFull()){
            array[++top]=key;
        }
        else{
            System.out.println("Stack is full");
        }
    }
    public int returnTop(){
        return array[top];
    }
    
}
