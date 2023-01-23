package com.splwg;

import java.io.File;
import java.net.URL;

import junit.framework.Test;
import junit.framework.TestSuite;
import junitx.util.DirectorySuiteBuilder;
import junitx.util.SimpleTestFilter;
import junitx.util.TestFilter;

import com.splwg.base.api.testers.AbstractAllTests;
import com.splwg.base.common.ClassUtils;
import com.splwg.shared.common.LoggedException;
import com.splwg.shared.logging.Logger;
import com.splwg.shared.logging.LoggerFactory;


/**
 * This class will gather all tests into a single suite to be executed under a single JVM.
 *
 * @author   Brian Conlon
 * @version  $Revision$
 */
public class AllTests
//    extends AbstractAllTests {
//
//    public static Test suite() throws Exception {
//        TestSuite suite = new TestSuite();
//
//        suite.addTest(new AllTests().getSuite());
//        return suite;
//    }
{
private static Logger logger = LoggerFactory.getLogger(AllTests.class);
public static Test suite() throws Exception {
    TestSuite suite = new TestSuite();
    suite.addTest(new AllTests().getSuite(new DefaultTestFilter()));
    return suite;
}

public TestSuite getSuite(TestFilter testFilter) throws Exception {
    DirectorySuiteBuilder builder = new DirectorySuiteBuilder();
    logger.info("Collecting tests");
System.out.println("Collecting tests");
    //cm.domain.onlinethreading.TestJugad_Test
    //Class cls = Class.forName("cm.domain.onlinethreading.TestJugad_Test");
    builder.setFilter(testFilter);
    
    String resourceName = getClass().getName().replace('.', '/') + ".class";

    System.out.println("Collecting tests resourceName "+resourceName);
    URL urlOfThisClass = ClassUtils.getClassLoader().getResource(resourceName);
    if (urlOfThisClass == null) {
      throw LoggedException.raised(logger, "Could not locate resource " + resourceName);
    }
    logger.info("URL of this class: " + urlOfThisClass);
System.out.println("URL of this class: " + urlOfThisClass);
    
    File  directory = (new File(urlOfThisClass.getFile())).getParentFile().getParentFile().getParentFile();
    logger.info("URL of this class: dir " + directory);
    if (!directory.exists()) {
      throw LoggedException.raised(logger, "The test directory does not exist: " + directory);
    }
    Test test = builder.suite(directory);
    TestSuite suite = new TestSuite();
    
    suite.addTest(test);
    //suite.addTest(AfterAllTests.suite());
    
    int testCaseCount = test.countTestCases();
    if (testCaseCount == 0) {
      logger.warn("No tests found");
    } else {
      logger.info(testCaseCount + " tests found");
    } 
    
    
    return suite;
  }






 
 public static class DefaultTestFilter
   extends SimpleTestFilter
 {
   public boolean include(Class clazz) { return (super.include(clazz) && !AbstractAllTests.class.isAssignableFrom(clazz)); }
 }

}
