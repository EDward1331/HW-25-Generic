package org.itstep.step01;

import java.util.Comparator;

/**
 * Класс для тестирования кортежа ObjectPair
 *
 * @author Nathan Sprague
 * @version V1, 8/2016
 */
public class ObjectPairDriver {

    /**
     * Создайте несколько пар стадионов, затем распечатайте название стадиона с наибольшей вместимостью.
     *
     * @param args Не используется
     */
    public static void main(String[] args) {

        ObjectPair[] stadiums = new ObjectPair[3];
        stadiums[0] = new ObjectPair("Bridgeforth Stadium", 25000);
        stadiums[1] = new ObjectPair("Michigan Stadium", 109901);
        stadiums[2] = new ObjectPair("Lane Stadium", 66233);


        //System.out.println(stadiums[0]);

        System.out.println(largestStadium(stadiums));
    }


    /**
     * Возвращает название стадиона с наибольшей вместимостью.
     *
     * @param stadiums Массив ObjectPairs, где каждая пара содержит название стадиона, за которым следует целое число
     * @return Название стадиона с наибольшей вместимостью
     */
    public static String largestStadium(ObjectPair[] stadiums) {
        // TODO: реализуйте это метод в соответствии с комментариями
        if(stadiums == null || stadiums.length == 0){
            return null;
        }
        ObjectPair largestStadium = stadiums[0];
        for (int i = 0; i < stadiums.length; i++) {
            if(compare(largestStadium,stadiums[i])<0){
                largestStadium = stadiums[i];
            }
        }
        return ((ObjectPair) largestStadium).getFirst().toString();
    }
    public static int compare(Object a1, Object a2){
        if(a1 instanceof ObjectPair && a2 instanceof ObjectPair){
            ObjectPair o1 = (ObjectPair)a1;
            ObjectPair o2 = (ObjectPair)a2;
            return (Integer)o1.getSecond() - (Integer)o2.getSecond();
        }
        return 0;
    }
}
