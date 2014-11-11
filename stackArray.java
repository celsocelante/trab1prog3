public class stackArray extends stack{
	String[] items;
	int size;
	int top = -1;

	public stackArray(int size){
		this.size = size;
		items = new String[size];
	}

	public boolean empty(){
		return top == - 1;
	}	
	public int whatSize(){
		return empty() ? 0 : top + 1;
	}
	public void push(String s) throws stackException{
		if(whatSize() > size)
			throw new stackException("Exceeded supported size of stack.");
		else{
			items[top+1]=s;
			top++;
		} 
	}
	public String pop() throws stackException{
		if(empty())
			throw new stackException("Stack is empty.");
		else{
			top--;
			return items[top+1];
		}
	}

}