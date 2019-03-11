package ch.heigvd.res.labio.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Logger;

/**
 * This class transforms the streams of character sent to the decorated writer.
 * When filter encounters a line separator, it sends it to the decorated writer.
 * It then sends the line number and a tab character, before resuming the write
 * process.
 *
 * Hello\n\World -> 1\Hello\n2\tWorld
 *
 * @author Olivier Liechti
 */
public class FileNumberingFilterWriter extends FilterWriter {

  private static final Logger LOG = Logger.getLogger(FileNumberingFilterWriter.class.getName());
  private int counter = 1;
  private boolean theEndOfLine = false;
  public FileNumberingFilterWriter(Writer out) {
    super(out);
  }

  @Override
  public void write(String str, int off, int len) throws IOException {
    write(str.toCharArray(), off, len);
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
    for(int i = off; i < off + len ; ++i)
      write(cbuf[i]);

  }

  @Override
  public void write(int c) throws IOException {
    //casaes first line or WINDOWS or MACOS
    if (counter == 1 || (theEndOfLine && c != '\n')) {
      out.write(new StringBuilder( counter++ + "\t").toString());
      theEndOfLine = false;
    }
    out.write(c);

    if(c == '\r')
    {
      theEndOfLine = true;
    }
    // a new line for Linux
    else if (c == '\n')
    {
      out.write(new StringBuilder( counter++ + "\t").toString());
      theEndOfLine = false;
          }
  }

}
