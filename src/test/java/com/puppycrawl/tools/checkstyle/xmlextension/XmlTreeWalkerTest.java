/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puppycrawl.tools.checkstyle.xmlextension;

import com.puppycrawl.tools.checkstyle.XmlTreeWalker;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.stream.XMLStreamException;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author vista
 */
public class XmlTreeWalkerTest {

    private static final String[] args = new String[]{"-c", "target/test-classes/config.xml", "-r", "target/test-classes/xmltree"};
    
    @Test
    public void walkTest() throws IOException, URISyntaxException, XMLStreamException, SAXException {
        
        File file = new File(XmlTreeWalkerTest.class.getResource("/test.xml").toURI());
        
        DetailAST tree = XmlTreeWalker.parse(new InputSource(new FileInputStream(
                file)), 
                file);

        Assert.assertEquals(2, tree.getNumberOfChildren());
    }

    @Test
    public void configTest() {
        Main.main(args);
    }
}
