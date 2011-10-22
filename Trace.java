/**
 * The Trace aspect injects tracing messages before and after
 * method main of class HelloWorld.
 */
package helloworld;

aspect Trace  {

  pointcut printouts():
	execution(public * *(..));

  before(): printouts() {
    System.out.println("#>"+thisEnclosingJoinPointStaticPart);
  }
  after():  printouts() {
    System.out.println("#<"+thisEnclosingJoinPointStaticPart);
  }
}