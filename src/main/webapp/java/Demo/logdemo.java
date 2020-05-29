package Demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class logdemo {

        private static final Logger LOGGER = LoggerFactory.getLogger(logdemo.class);


        public static void main(String[] args) throws IOException, InterruptedException {

            LOGGER.debug("线程开始");
            Thread.sleep(1 * 1000);

            test1();
        }

        public static void test1() {
            LOGGER.debug("test1方法");
        }

    }

