package ch.heigvd.statique.benchmarks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class MyFirstBenchmark {

  List<String> list;

  @Param({"10", "100", "1000"})
  private int size;

  @Setup
  public void setup() {
    list = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      list.add("kv" + i);
    }
  }

  @Benchmark
  public void benchmarkHashMap() {
    Map<String, String>  map = new HashMap<>();;
    for (String kv : list) {
      map.put(kv, kv);
    }
  }

  @Benchmark
  public void benchmarkTreeMap() {
    Map<String, String>  map = new TreeMap<>();
    for (String kv : list) {
      map.put(kv, kv);
    }
  }

}
