/**
 * Date:     2018/11/310:18
 * AUTHOR:   Administrator
 */
package com.zhou.mode_021_memento.use_mode;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 具体的备忘录发起者
 * 2018/11/3  10:18
 * created by zhoumb
 */
public class Originator {
    private Map<String, String> state;

    public Originator() {
        state = Maps.newHashMap();
    }

    public MementoIF createMemento() {
        return new Memento(this.state);
    }

    public void restoreMemnto(MementoIF memento) {
        state = ((Memento) memento).getState();
    }

    public void showState() {
        System.out.println("now state:" + state.toString());
    }

    public void testState1(){
        state.put("blood","500");
        state.put("progress","gate1 end");
        state.put("enemy","5");
    }

    public void testState2(){
        state.put("blood","450");
        state.put("progress","gate3 end");
        state.put("enemy","3");
    }

    private class Memento implements MementoIF {
        private Map<String, String> state;

        public Memento(Map<String, String> state) {
            this.state = Maps.newHashMap(state);//这样克隆一份  不指向同一个地址
        }

        public Map<String, String> getState() {
            return state;
        }

        public void setState(Map<String, String> state) {
            this.state = state;
        }
    }
}
