package com.weichuang.day11Demo;

import java.util.Optional;

/**
 * Optional jdk1.8之后
 */
public class OptionalDemo {
    public static void main(String[] args) {
        //Optional创建方式
        Optional<String> opt = Optional.of("cc");
        //指定的值为null那么会返回一个空的Optional
        Optional<Object> o = Optional.ofNullable(null);

        System.out.println(o.isPresent());
        System.out.println(opt.get());
        //若有值，使用consumer操作值
        opt.ifPresent(v-> System.out.println(v));
        //取值若有则返回值，否则返回指定的默认值
        System.out.println(o.orElse("no val"));
        //System.out.println(o.orElseThrow(() -> new RuntimeException("没有取到值!")));
        System.out.println("------------------------------");
        Optional<String> newOpt = opt.map((val) -> val.toUpperCase());
        System.out.println(newOpt.orElse("no new val"));
        //也是接收一个Function函数式接口，只不过需要我们自己封装一下Optional即可
        newOpt = opt.flatMap((val)->Optional.of(val.toUpperCase() + "-flatMap"));
        System.out.println(newOpt.orElse("flatMap no val"));
    }
}
