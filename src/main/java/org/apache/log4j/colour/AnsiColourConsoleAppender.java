package org.apache.log4j.colour;

import com.thoughtworks.xstream.XStream;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.helpers.QuietWriter;
import org.apache.log4j.spi.ErrorHandler;

import java.io.Writer;
import java.lang.reflect.Method;

/**
 * @author weidong.xu@bytehelps.com
 *
 */
public final class AnsiColourConsoleAppender extends ConsoleAppender {

    private String attribute = "NORMAL";
    private String fontColor = "RED";
    private String backgroundColor = "BLACK";

    private XStream xStream = new XStream();

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public synchronized void setWriter(Writer writer) {
        reset();
        try {
            this.qw = createJustQuietWriter(writer, errorHandler);
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        writeHeader();
    }

    /**
     * Use javassit to create a proxy on QuietWriter Object
     *
     * @param writer
     * @param errorHandler
     * @return
     * @throws Exception
     */
    public QuietWriter createJustQuietWriter(Writer writer, ErrorHandler errorHandler) throws Exception {
        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(QuietWriter.class);

        MethodHandler handler = new MethodHandler() {

            @Override
            public Object invoke(Object self, Method overridden, Method forwarder,
                    Object[] args) throws Throwable {
                if (overridden.getName().equalsIgnoreCase("write")) {
                    args[0] = getColoredMessage((String) args[0]);
                }
                return forwarder.invoke(self, args);
            }
        };
        Class clz[] = new Class[2];
        Object[] args = new Object[2];
        args[0] = writer;
        args[1] = errorHandler;
        clz[0] = Writer.class;
        clz[1] = ErrorHandler.class;
        QuietWriter qw = (QuietWriter) factory.create(clz, args, handler);

        return qw;

    }

    /**
     *
     * @param message
     * @return
     */
    protected String getColoredMessage(final String message) {
        AnsiColourProperty.Attribute _attri = AnsiColourProperty.Attribute.valueOf(attribute.toUpperCase());
        AnsiColourProperty.Color _fColor = AnsiColourProperty.Color.valueOf(fontColor.toUpperCase());
        AnsiColourProperty.Color _bColor = AnsiColourProperty.Color.valueOf(backgroundColor.toUpperCase());

        return AnsiColourProperty.format(message, _attri, _fColor, _bColor);
    }

}
