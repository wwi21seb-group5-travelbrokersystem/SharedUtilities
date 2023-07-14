package org.wwi21seb.vs.group5.Logger;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;

public class LoggerFactory {

    private static class LogFormatter extends Formatter {
        private final DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        @Override
        public synchronized String format(LogRecord record) {
            String loggerName = record.getLoggerName();
            String simpleName = loggerName.substring(loggerName.lastIndexOf(".") + 1);
            return String.format(
                    "%s %s %s: %s%n",
                    record.getLevel(),
                    formatter.format(record.getInstant()),
                    simpleName,
                    formatMessage(record)
            );
        }
    }

    public static Logger setupLogger(String name) {
        Logger logger = Logger.getLogger(name);
        logger.setUseParentHandlers(false); // prevent double logging
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new LogFormatter());
        logger.addHandler(consoleHandler);
        return logger;
    }
}
