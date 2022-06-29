package on_java.enumeration;

/**
 * Data: 2022/06/30
 * description :　枚举类型的基本特性 - ON JAVA 进阶版
 */
enum Shrubbery {
    GROUND, CRAWLING, HANGING
}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            // ordinal ： 返回一个从0开始的int值
            System.out.println(s + " ordinal: " + s.ordinal());

            // equals,hashCode会由编译器自动生成，实现了Comparable接口，还实现了Serializable接口
            System.out.print(s.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.print(s.equals(Shrubbery.CRAWLING) + " ");
            System.out.println(s == Shrubbery.CRAWLING);

            // getDeclaringClass得到该枚举实例所属的外部包包装类
            System.out.println(s.getDeclaringClass());

            // 返回枚举实例被声明的名称
            System.out.println(s.name());
            System.out.println("**********************");
        }

        // 根据字符串生成一个枚举值
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            // valueOf根据传入的String，返回名称与该String匹配的枚举实例
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrub);
        }
    }
}
