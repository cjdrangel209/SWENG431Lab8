
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
        //cd.printSkeleton(c);
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
    public void printMethods() {

        Method[] methods = c.getDeclaredMethods();

        for(Method m: methods){

            System.out.print(" ");

            String modifier = Modifier.toString(m.getModifiers());
            System.out.print(modifier);
            System.out.print(" ");

            String returnType = m.getReturnType().getName();
            System.out.print(returnType);
            System.out.print(" ");

            String methodName = m.getName();
            System.out.print(methodName);

            // prints parameters
            System.out.print("(");
            Class[] parameterTypes = m.getParameterTypes();

            ArrayList<String> parameterTypeCounter = new ArrayList<>();

            for(int i = 0; i < parameterTypes.length; i++){

                // prints parameter type
                String pTypeName = parameterTypes[i].getSimpleName();
                System.out.print(pTypeName);
                System.out.print(" ");

                // gets number for generic parameter name
                parameterTypeCounter.add(pTypeName);
                int frequency = Collections.frequency(parameterTypeCounter, pTypeName);

                // prints generic parameter name
                String pName = pTypeName.charAt(0) + String.valueOf(frequency);
                System.out.print(pName);

                // handles commas
                if(i != parameterTypes.length - 1)
                {
                    System.out.print(", ");
                }
            }

            System.out.print(")");

            AnnotatedType[] aa = m.getAnnotatedExceptionTypes();
            for(AnnotatedType a : aa){
                String e = a.getType().toString();
                int i = e.lastIndexOf('.');
                String ex = e.substring(i + 1);
                System.out.print(" throws " + ex);
            }
            System.out.println(";");
        }
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
}
