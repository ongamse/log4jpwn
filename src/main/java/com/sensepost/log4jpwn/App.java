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

    // Logging ua:
    if (ua != null) {
        logger.error("logging ua: " + Encode.forHtml(ua));
    } else {
        logger.error("logging ua: null");
    }

    // Logging pwn:
    if (pwn != null) {
        logger.error("logging pwn: " + Encode.forHtml(pwn));
    } else {
        logger.error("logging pwn: null");
    }

    // Logging pth:
    if (pth != null) {
        logger.error("logging pth: " + Encode.forHtml(pth));
    } else {
        logger.error("logging pth: null");
    }

    return "ok: ua: " + Encode.forHtml(ua) + " " + "pwn: " + Encode.forHtml(pwn) + " pth:" + Encode.forHtml(pth);
}





