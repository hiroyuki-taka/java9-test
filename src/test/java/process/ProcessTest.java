package process;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class ProcessTest {

    @Test
    void test() {
        // psっぽいものが作れる
        ProcessHandle.allProcesses()
                .sorted(Comparator.comparingLong(ProcessHandle::pid))
                .forEach(p -> {
                    System.out.printf("pid: %d, cmd: %s, option:%s%n",
                            p.pid(),
                            p.info().command().orElse(""),
                            String.join(" ",  p.info().arguments().orElse(new String[]{})));
                });
    }
}
