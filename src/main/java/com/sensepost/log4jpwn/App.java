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

    Logger logger = LogManager.getLogger(App.class);
    logger.error("User-Agent: {}, pwn: {}, pth: {}", Masker.mask(ua), Masker.mask(pwn), Masker.mask(pth));

    return "ok: ua: " + Masker.mask(ua) + " " + "pwn: " + Masker.mask(pwn) + " pth:" + Masker.mask(pth);
}



    }
}




