package com.lionel.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 求最接近某个值的数字组合
 */
public class NumberSumApproachValue {

    /**
     * 查询count个值相加最接近value的组合
     *
     * @param list  源集合
     * @param count 数字个数
     * @param value 目标值
     * @return 结果
     */
    private static List<Integer> getGroup(List<Integer> list, int count, int value) {
        List<Integer> resultList = new ArrayList<>();
        //先从小到大排个序，去count个最小的值相加，如果都比value大，则不需要查找，一定没有
        java.util.Collections.sort(list);
        int countSum = 0;
        for (int i = 0; i < count; i++) {
            countSum += list.get(i);
        }
        if (countSum > value) {
            return resultList;
        }
        int result = 0;
        if (count == 1) {
            countSum = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) > countSum && list.get(i) <= value) {
                    countSum = list.get(i);
                }
            }
            resultList.add(countSum);
        } else if (count == 2) {
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    countSum = list.get(i) + list.get(j);
                    if (countSum > result && countSum <= value) {
                        result = countSum;
                        resultList.clear();
                        resultList.add(list.get(i));
                        resultList.add(list.get(j));
                    }
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                List<Integer> list1 = new ArrayList<>(list);
                list1.remove(list.get(i));
                //递归去查询除去该值后count-1的组合情况
                List<Integer> group = getGroup(list1, count - 1, value - list.get(i));
                if (group.size() == count - 1) {
                    countSum = list.get(i);
                    for (Integer integer : group) {
                        countSum += integer;
                    }
                    if (countSum > result && countSum <= value) {
                        result = countSum;
                        resultList.clear();
                        resultList.addAll(group);
                        resultList.add(list.get(i));
                    }
                }
            }
        }
        return resultList;
    }
}
