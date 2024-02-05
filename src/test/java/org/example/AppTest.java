package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testMerge(){
        /**
         * формируем упорядоченный массив
         */
        final int COUNT = 100;
        final int STEP = 10;
        Random random = new Random();
        LinkedList<Integer> a = new LinkedList<>();
        int[] c=new int[COUNT];
        int k=0;
        for (int i=0;i<COUNT;i++){
            a.add(k+random.nextInt(STEP));
            c[i]=a.getLast();
            k+=STEP;
        }
        /**
         * Случайным образом перемешиваем
         */
        int[] b=new int[COUNT];
        k=0;int tmp=0;
        while (a.size()>0){
            tmp = random.nextInt(a.size());
            b[k]= a.get(tmp);
            a.remove(tmp);
            k++;
        }
        /**
         * Сортировка и проверка
         */
        new Merge().run(b);
        Assert.assertArrayEquals(c,b);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
