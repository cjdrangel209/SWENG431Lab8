
package lab8;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Cory Drangel
 * @author Noah Spott
 */
class MyJavap {
    private Class c;
    
    public void setClass(String str) throws ClassNotFoundException{
        c = Class.forName(str);
    }
    
    public Class getMJPClass(){
        return c;
    }
    
    /**
     * Prints name of class object.
     *  Form: modifier class className;
     * @param c - class object
     */
    public void printClassName(Class c){

        // package name currently not required
        //String packageName = c.getPackageName();
        //System.out.println(packageName);

        String modifier = Modifier.toString(c.getModifiers());
        System.out.print(modifier);
        System.out.print(" ");

        String typeName = "class";
        System.out.print(typeName);
        System.out.print(" ");

        String className = c.getSimpleName();
        System.out.print(className);
        System.out.print(" ");
    }

    /**
     * Prints all fields of class object.
     *  Form: modifier type fieldName;
     * @param c - class object
     */
    public void printFields(Class c) {

        Field[] fields = c.getDeclaredFields();

        for(Field f : fields){

            System.out.print(" ");

            String modifier = Modifier.toString(f.getModifiers());
            System.out.print(modifier);
            System.out.print(" ");

            String typeName = f.getType().getName();
            System.out.print(typeName);
            System.out.print(" ");

            String fieldName = f.getName();
            System.out.print(fieldName);
            System.out.print(";");
            System.out.println();
        }

    }

    /**
     * Prints methods of class object.
     *  Form: modifier returnType methodName(type t1, type t2);
     * @param c - class object
     */
    public String[] printMethods() {

        Method[] methods = c.getDeclaredMethods();
  
        int i = 0;
        for(Method m: methods){
            i++;
        }
        
        int j = 0;
        String[] sa = new String[i];
        for (Method m: methods){
            sa[j] = m.toGenericString();
            j++;
        }
        
        return sa;
    }
    
    public String[] printConstructors(){
        Constructor[] con = c.getConstructors();
        
        
        int i =0;
        for(Constructor constructor: con){
            i++;
        }
        
        String[] sa = new String[i];
        
        int j = 0;
        for(Constructor constructor: con){
            sa[j] = constructor.toGenericString();
            j++;
        }
    
        return sa;
    }
    
    public Constructor getConstructor(int i){
        Constructor[] cons = c.getConstructors();
        Constructor constructor = null;
        
        int j = 0;
        for(Constructor con: cons){
            if (j == i){
                constructor = con;
            }
            j++;
        }
        
        return constructor;
    }
    
    public Method getMethod(int i){
        Method[] methods = c.getMethods();
        Method method = null;
        
        int j = 0;
        for(Method m: methods){
            if(j == i){
                method = m;
            }
            j++;
        }
        
        return method;
    }
}
