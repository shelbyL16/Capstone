package signsupport;

//imports for XML readers
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import com.sun.org.apache.regexp.internal.RE;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class ReadXML
{


    public ReadXML() {
    }

    public static void main(String argv[])
    {
        ArrayList<Screen> screenArr = new ArrayList<>();

        //try to read in the file
        try
        {
            //create the file to read in
            //File XmlFile = new File("Documents\\University\\2017\\Courses\\Second Semester\\CSC3003S\\Capstone\\Program\\Capstone-master\\elearnerselfstudy.xml");

            File XmlFile = new File("/Users/Lucia/Dropbox/UCT 2017/CSC3003S/Capstone Project/Code/SignSupport/src/signsupport/elearnerselfstudy.xml");
            //Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(XmlFile);

            //need to normalize - read the stack overflow
            document.getDocumentElement().normalize();

            //print out root for testing purposes
            //System.out.println("The root element is :" + document.getDocumentElement().getNodeName() + "\n");

            //list of lessons - it is reading the elements into the list fine
            NodeList nLessonList = document.getElementsByTagName("lesson");
            //System.out.println("I have the lesson list ready");
            //System.out.println("The length of the lessonList is: " + nLessonList.getLength()+"\n");

            //list for the screens - it is reading the elements into the list fine, the error is somewhere else
            NodeList nScreenList = document.getElementsByTagName("screen");
            //System.out.println("I have the screen list ready");
            //System.out.println("The length of the screenList is: " + nScreenList.getLength()+ "\n");

            //lesson list iteration
            for (int temp = 0; temp < nLessonList.getLength(); temp++)
            {
                Node nNode = nLessonList.item(temp);
                //System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    //System.out.println("Are we even insdie the if bro - we definitely penetrate the if");
                    //System.out.println("Still not a good enough reason to use the word penetrate" + "\n");

                    Element eElement = (Element) nNode;

                    //System.out.println("Lesson : " + eElement.getAttribute("lesson"));

                }//end if
            }//end for loop through tree

            //screen list iteration
            for (int temp = 0; temp < nScreenList.getLength(); temp++)
            {

                Node nNode2 = nScreenList.item(temp);
                //System.out.println("\nCurrent Element :" + nNode2.getNodeName());

                // create new screens for array
                Screen screen = new Screen();

                if (nNode2.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) nNode2;

                    //return elements
                    //System.out.println("Screen : " + eElement.getAttribute("screen"));
                    //System.out.println("ScreenId is  : " + eElement.getElementsByTagName("screenID").item(0).getTextContent());
                    //System.out.println("Video is  : " + eElement.getElementsByTagName("video").item(0).getTextContent());
                    //System.out.println("Video Caption is  : " + eElement.getElementsByTagName("vid_caption").item(0).getTextContent());

                    // add data to screen object
                    screen.setScreenID(eElement.getElementsByTagName("screenID").item(0).getTextContent());
                    screen.setVideoURL(eElement.getElementsByTagName("video").item(0).getTextContent());
                    screen.setVidCaption(eElement.getElementsByTagName("vid_caption").item(0).getTextContent());

                    screenArr.add(screen);

                }//end if
            }//end for list iteration
        }//end try

        //catch
        catch (Exception e)
        {
            e.printStackTrace();
        }//end catch

        System.out.println("_____________________________________________________________");
        System.out.println("Printing out Screen array");

        for (int i=0; i<screenArr.size(); i++) {

            System.out.println(screenArr.get(i));
        }


    }//end main
}//end class