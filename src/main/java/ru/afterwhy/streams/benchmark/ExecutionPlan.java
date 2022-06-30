package ru.afterwhy.streams.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
public class ExecutionPlan {

    @Param({ "10", "10000", "1000000" })
    public int dataSize;

    public List<TestData1> data;

    @Setup(Level.Invocation)
    public void setUp() {
        data = IntStream.range(0, dataSize)
                .boxed()
                .map(this::buildTestData)
                .collect(Collectors.toList());
    }

    private TestData1 buildTestData(Integer i) {
        TestData1 testData = new TestData1();
        testData.setField1("Field1_" + i);
        testData.setField2("Field2_" + i);
        testData.setField3("Field3_" + i);
        testData.setField4("Field4_" + i);
        testData.setField5("Field5_" + i);
        testData.setField6("Field6_" + i);
        testData.setField7("Field7_" + i);
        testData.setField8("Field8_" + i);
        testData.setField9("Field9_" + i);
        testData.setField10("Field10_" + i);
        testData.setField11("Field11_" + i);
        testData.setField12("Field12_" + i);
        testData.setField13("Field13_" + i);
        testData.setField14("Field14_" + i);
        testData.setField15("Field15_" + i);
        testData.setField16("Field16_" + i);
        testData.setField17("Field17_" + i);
        testData.setField18("Field18_" + i);
        testData.setField19("Field19_" + i);
        testData.setField20("Field20_" + i);
        return testData;
    }
}
