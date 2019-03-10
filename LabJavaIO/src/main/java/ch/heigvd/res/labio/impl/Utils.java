package ch.heigvd.res.labio.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());
  private static final String WIN_SEPARATOR = "\r\n",
          MACOS9_SEPARATOR = "\r",
          UNIX_SEPARATOR = "\n";

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
    String[] linesTab;

    //verif if there is a separator
    if (!lines.contains(WIN_SEPARATOR) && !lines.contains(MACOS9_SEPARATOR) && !lines.contains(UNIX_SEPARATOR)) {
      return new String[]{"", lines};

    } // verif if there is a  WINDOWS separator
    else if (lines.contains(WIN_SEPARATOR))
    {
      linesTab = lines.split(WIN_SEPARATOR, 2);
      linesTab[0] = linesTab[0] + WIN_SEPARATOR;

    } // verif if there is a  MACOS9 separator
    else if (lines.contains(MACOS9_SEPARATOR))
    {
      linesTab = lines.split(MACOS9_SEPARATOR, 2);
      linesTab[0] = linesTab[0] + MACOS9_SEPARATOR;

    } // verif if there is a UNIX line separator
    else {
      linesTab = lines.split(UNIX_SEPARATOR, 2);
      linesTab[0] = linesTab[0] + UNIX_SEPARATOR;
    }
    return linesTab;  }

}
