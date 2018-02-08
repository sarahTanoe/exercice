package injection;
import org.jdom2.*;
import org.jdom2.input.*;

import jdk.nashorn.internal.objects.annotations.Constructor;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

import org.jdom2.filter.*;
import java.util.List;
public class Test 
{
	static org.jdom2.Document document;
	static Element racine;
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		SAXBuilder sxb = new SAXBuilder();
		try
		{
			document = sxb.build(new File("injection.xml"));
		}
		catch(Exception e) {}
		
		racine = document.getRootElement();
		
		java.lang.reflect.Constructor cons = getClasse().getConstructor(new Class[] {List.class});
		Pile<String> pile = (Pile<String>) cons.newInstance(getInjection().newInstance());
		
		pile.empiler("tanoe");
		pile.empiler("sarah");
		
		System.out.println("Element 1 depiler est : " + pile.depiler());
		System.out.println("Element 2 depiler est : " + pile.depiler());

	}
	
	static Class getClasse() throws ClassNotFoundException{
		Element injection = racine.getChild("injection");
		return Class.forName("injection." + injection.getAttributeValue("classe"));
	}
	
	static Class getInjection() throws  ClassNotFoundException{
		Element injection = racine.getChild("injection");
		return Class.forName(injection.getAttributeValue("injection"));
	}

}
