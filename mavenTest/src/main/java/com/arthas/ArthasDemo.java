package com.arthas;

import com.taobao.arthas.common.AnsiLog;
import com.taobao.arthas.common.IOUtils;
import com.taobao.arthas.common.PidUtils;
import com.taobao.middleware.cli.CLI;
import com.taobao.middleware.cli.annotations.CLIConfigurator;
import com.taobao.middleware.cli.annotations.Description;
import com.taobao.middleware.cli.annotations.Name;
import com.taobao.middleware.cli.annotations.Summary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Wentworth .
 * @date 2019/11/26 8:36 下午
 */
@Name("arthas-boot")
@Summary("Bootstrap Arthas")
@Description("EXAMPLES:\n" + "  java -jar arthas-boot.jar <pid>\n" + "  java -jar arthas-boot.jar --target-ip 0.0.0.0\n"
        + "  java -jar arthas-boot.jar --telnet-port 9999 --http-port -1\n"
        + "  java -jar arthas-boot.jar --tunnel-server 'ws://192.168.10.11:7777/ws'\n"
        + "  java -jar arthas-boot.jar --tunnel-server 'ws://192.168.10.11:7777/ws' --agent-id bvDOe8XbTM2pQWjF4cfw\n"
        + "  java -jar arthas-boot.jar --stat-url 'http://192.168.10.11:8080/api/stat'\n"
        + "  java -jar arthas-boot.jar -c 'sysprop; thread' <pid>\n"
        + "  java -jar arthas-boot.jar -f batch.as <pid>\n"
        + "  java -jar arthas-boot.jar --use-version 3.1.5\n"
        + "  java -jar arthas-boot.jar --versions\n"
        + "  java -jar arthas-boot.jar --session-timeout 3600\n" + "  java -jar arthas-boot.jar --attach-only\n"
        + "  java -jar arthas-boot.jar --repo-mirror aliyun --use-http\n" + "WIKI:\n"
        + "  https://alibaba.github.io/arthas\n")
public class ArthasDemo {
    public static void main(String[] args) throws IOException {
        int currentPid = Integer.parseInt(PidUtils.currentPid());
        System.out.println(currentPid);
    }
}
