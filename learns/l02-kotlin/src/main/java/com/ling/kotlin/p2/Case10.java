package com.ling.kotlin.p2;

import com.ling.kotlin.p1.Case09Kt;

import java.io.IOException;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/**
 * @author : wangchengzhen
 * @time : 2022/5/13
 * @desc : Kotlin与Java互操作
 */
public class Case10 {

    public static void main(String[] args) {
        // @JvmName
        Hero.testJvmName();

        // @JvmField
        TestJvmField testJvmField = new TestJvmField();
        // testJvmField.getSpells()
        System.out.println(testJvmField.spells);

        // @JvmOverloads
        Hero.testJvmOverloads();

        // @JvmStatic
        // SpellBook.Companion.getMAX();
        // SpellBook.Companion.getSpellBook();
        SpellBook.getSpellBook();

        // @Throws
        try {
            Hero.acceptApology();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 函数类型操作
        Function1<String, Unit> translator = Hero.getTranslator();
        translator.invoke("TRUCE");
        Function2<String, Integer, Unit> upper = Hero.getUpper();
        upper.invoke("Jack", 20);
    }

    public String name;

    public String utterGreeting() {
        return "utter greeting";
    }

    public String determineFriendshipLevel() {
        return null;
    }
}
