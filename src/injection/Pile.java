package injection;
import java.util.List;
import java.util.LinkedList;

public class Pile<T> 
{
	private final List<T> stk;
	
	public Pile()
	{
		stk = new LinkedList<T>();
	}
	
	public Pile(List<T> l)
	{
		stk = l;
	}
	
	public void empiler(T valeur) {
		stk.add(valeur);
	}
	
	T depiler() {
		T val = stk.get(stk.size()-1);
		stk.remove(stk.size()-1);
		return val;
	}
}
