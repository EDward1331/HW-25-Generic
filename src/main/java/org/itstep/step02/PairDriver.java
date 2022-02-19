package org.itstep.step02;

// TODO: Пишите ваш код здесь
public class PairDriver {
    public static void main(String[] args) {

        Pair<String, Integer>[] stadiums = new Pair[3];
        stadiums[0] = new Pair<>("Bridgeforth Stadium", 25000);
        stadiums[1] = new Pair<>("Michigan Stadium", 109901);
        stadiums[2] = new Pair<>("Lane Stadium", 66233);

        System.out.println(stadiums[0]);

        System.out.println(largestStadium(stadiums));
    }

    public static String largestStadium(Pair[] stadiums) {
        // TODO: реализуйте это метод в соответствии с комментариями
        if (stadiums == null || stadiums.length == 0) {
            return null;
        }
        Pair largestStadium = stadiums[0];
        for (int i = 0; i < stadiums.length; i++) {
            if(compare(largestStadium,stadiums[i])<0){
                largestStadium = stadiums[i];
            }
        }

        return (String) largestStadium.getFirst();
    }

    public static int compare(Object o1, Object o2) {
        if (o1 instanceof Pair && o2 instanceof Pair) {
            Pair p1 = (Pair) o1;
            Pair p2 = (Pair) o2;
            if (p1.getSecond() instanceof Integer && p2.getSecond() instanceof Integer) {
                return (Integer) p1.getSecond() - (Integer) p2.getSecond();
            }
            return Integer.parseInt(p1.getSecond().toString()) -
                    Integer.parseInt(p2.getSecond().toString());
        }
        return 0;
    }
}
