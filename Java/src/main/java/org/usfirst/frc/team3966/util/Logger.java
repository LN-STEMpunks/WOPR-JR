package org.usfirst.frc.team3966.util;

//import jaci.openrio.toast.core.Toast;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Logging, handling toast, etc Now with ISO compliant dates
 *
 * @author cade
 */
public class Logger {

    public static final DateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static void init() {
        //Toast.log().dateFormat = ISO_8601_FORMAT;
    }

    //public jaci.openrio.toast.lib.log.Logger _toast_logger;

    public Logger(String name, String ver) {
        String lname = name + (ver == "" ? "" : "@" + ver);
        //_toast_logger = new jaci.openrio.toast.lib.log.Logger(lname, jaci.openrio.toast.lib.log.Logger.ATTR_DEFAULT);
        //_toast_logger.dateFormat = ISO_8601_FORMAT;
        info("is online");
    }

    public Logger(String name) {
        this(name, "");
    }

    public void info(String things, Object... fmtObjs) {
        System.out.printf(things, fmtObjs);
        //_toast_logger.info(String.format(things, fmtObjs));
    }

}
