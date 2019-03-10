package ch.heigvd.res.labio.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {

    String Result[] = new String[2];
    int i = 0;

    // We look on each char of our lines, and we look if we get a \r ou \n. If we do, we check if the char after is a \n.
    for(;i < lines.length();i++)
    {
      if (lines.charAt(i) == '\r' || lines.charAt(i) == '\n')
      {
        if(i+ 1 < lines.length() && lines.charAt(i + 1) == '\n')
        {
          i += 1;
        }
        break;
      }
    }


    if(i < lines.length())
    {
      Result[0] = lines.substring(0,i+1);
      Result[1] = lines.substring(i+1);
    }
    else
    {
      Result[0] = "";
      Result[1] = lines;
    }
    return Result;
  }

}
