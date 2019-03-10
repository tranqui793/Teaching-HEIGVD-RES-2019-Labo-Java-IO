package ch.heigvd.res.labio.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Olivier Liechti
 */
public class UpperCaseFilterWriter extends FilterWriter {

  public UpperCaseFilterWriter(Writer wrappedWriter) {
    super(wrappedWriter);
  }
  public void write(String str) throws IOException {
      out.write(str.toUpperCase());
  }

  @Override
  public void write(String str, int off, int len) throws IOException {
    write(str.substring(off, off + len));
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
      StringBuilder str = new StringBuilder();
      for (int i = 0; i < cbuf.length; ++i) {
          str.append(cbuf[i]);
      }
      write(str.toString(),off,len);
  }

  @Override
  public void write(int c) throws IOException {
    write("" + (char) c);
  }

}
