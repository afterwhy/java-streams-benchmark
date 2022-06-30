package ru.afterwhy.streams.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List<TestData2> rangeStream(ExecutionPlan executionPlan) {
        List<TestData1> data = executionPlan.data;
        return IntStream.range(0, data.size())
                .boxed()
                .map(i -> new TestData2(data.get(i).getField1()))
                .collect(Collectors.toList());
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List<TestData2> regularStream(ExecutionPlan executionPlan) {
        return executionPlan.data.stream().map(d -> new TestData2(d.getField1())).collect(Collectors.toList());
    }


    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List<TestData2> forLoop(ExecutionPlan executionPlan) {
        List<TestData2> result = new ArrayList<>(executionPlan.data.size());
        List<TestData1> data = executionPlan.data;
        for (int i = 0; i < data.size(); i++) {
            TestData1 testDatum = data.get(i);
            result.add(new TestData2(testDatum.getField1()));
        }
        return result;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public List<TestData2> foreachLoop(ExecutionPlan executionPlan) {
        List<TestData2> result = new ArrayList<>(executionPlan.data.size());
        for (TestData1 testDatum : executionPlan.data) {
            result.add(new TestData2(testDatum.getField1()));
        }
        return result;
    }

}
