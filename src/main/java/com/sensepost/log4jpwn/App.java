package com.sensepost.log4jpwn;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static spark.Spark.*;

public class App {
    static final Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {

        port(8080);

(req, res) -> {
    String ua = StringUtils.defaultString(req.headers("User-Agent"));
    String pwn = StringUtils.defaultString(req.queryParams("pwn"));
    String pth = StringUtils.defaultString(req.pathInfo());

    System.out.println("logging ua: " + ua);
    System.out.println("logging pwn: " + pwn);
    System.out.println("logging pth: " + pth);

    // trigger
    logger.error(ua);
    logger.error(pwn);
    logger.error(pth);

    return "ok: ua: " + ua + " " + "pwn: " + pwn + " pth:" + pth;
}

    }
}

