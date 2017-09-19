public class Task 
{
   String element = "";
   int id = 0;
   String path = "";
   String caption = "";
   
  //constructor method
  public Task(String e, int i, String p, String c) 
  {
      element = e;
      id = i;
      path = p;
      caption = c;
  }//end constructor
  
  //get element
  public String getElement()
  {
      return element;
  }//end getter
  
  //get id
  public int getID()
  {
      return id;
  }//end getter
  
  //get path
  public String getPath()
  {
      return path;
  }//end getter
  
  //get Caption
  public String getCaption()
  {
      return caption;
  }//end getter
  
  //set element
  public void setElement(String e)
  {
      element = e;
  }//end setter
  
  //set id
  public void setID(int i)
  {
       id = i;
  }//end setter
  
  //set path
  public void setPath(String p)
  {
       path = p;
  }//end setter
  
  //set Caption
  public void setCaption(String c)
  {
      caption = c;
  }//end setter
  
}//end class