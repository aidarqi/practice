package com.aidar.thinkinginjava.aslisttest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @desc
 * @date 17-6-19
 */
public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Powder(), new Crusty(), new Slush());
        //Arrays.asList()中只有Powder类型,因此会创建为List<Powder>而不是List<Show>
//        List<Snow> snow2 = Arrays.asList(new Light(), new Heavy(), new Powder());
        List<Snow> snow5 = Arrays.asList(new Light(), new Heavy(), new Slush());
        List<Snow> snow3 = new ArrayList<Snow>();
        //从第一个参数了解目标类型是什么
        Collections.addAll(snow3, new Light(), new Heavy());
        //通过在中间插入一条"线索",以告诉编译器对于由Arrays.asList()产生的目标类型是什么
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());

    }
}
