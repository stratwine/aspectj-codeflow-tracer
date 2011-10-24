/**
 * The Trace aspect injects tracing messages before and after
 * method main of class HelloWorld.
 */

package helloworld;


import org.aspectj.lang.*;
import org.aspectj.lang.reflect.*;
aspect Trace  {

static final void println(String s){ System.out.println(s); }

   pointcut demoExecs(): execution(public * *(..));

   Object around(): demoExecs()  {
      println("Intercepted message: " +
          thisJoinPointStaticPart.getSignature().getName());
      println("in class: " +
          thisJoinPointStaticPart.getSignature().getDeclaringType().getName());
      printParameters(thisJoinPoint);
      println("Running original method: \n" );
      Object result = proceed();
      println("  result: " + result );
      return result;
   }

   static private void printParameters(JoinPoint jp) {
      println("Arguments: " );
      Object[] args = jp.getArgs();
      String[] names = ((CodeSignature)jp.getSignature()).getParameterNames();
      Class[] types = ((CodeSignature)jp.getSignature()).getParameterTypes();
      for (int i = 0; i < args.length; i++) {
         println("  "  + i + ". " + names[i] +
             " : " +            types[i].getName() +
             " = " +            args[i]);
      }
   }

}