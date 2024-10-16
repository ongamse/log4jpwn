package com.sensepost.log4jpwn;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static spark.Spark.*;

public class App {
    static final Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {

        port(8080);

(req, res) -> {
    String ua = req.headers("User-Agent");
    String pwn = req.queryParams("pwn");
    String pth = req.pathInfo();

    logger.error("logging ua: {}", ua);
    logger.error("logging pwn: {}", pwn);
    logger.error("logging pth: {}", pth);

    return "ok: ua: " + ua + " " + "pwn: " + pwn + " pth:" + pth;
}

    }
}

