## 枚举类学习的Demo

通过这个demo对枚举类简单的学习了解

现在枚举类使用关键字enum来表示一个类
比如人的性别，可以使用枚举类来表示：

    class enum SexEnum{
        /**
             * 男女实例
             */
            MALE(1, "男"),
            FEMALE(2, "女");
        
            private int id;
            private String message;
        
            SexEnum (int id, String message){
                this.id = id;
                this.message = message;
            }
        
            /**
             *@Description: 根据输入的id来获取对应的性别实例
             *@parameters: [id]
             *@return: com.springboot.enumdemo.enumeration.SexEnum
             *@Author: 傅琦
             *@Date: 2019/4/23 19:28
             */
            public static SexEnum getSexById(int id){
                for (SexEnum sex: SexEnum.values()){
                    if (sex.getId() == id){
                        return sex;
                    }
                }
                return null;
            }
        
            /**
             *@Description: 根据所输入的属性来获取对应的性别实例
             *@parameters: [message]
             *@return: com.springboot.enumdemo.enumeration.SexEnum
             *@Author: 傅琦
             *@Date: 2019/4/23 19:29
             */
            public static SexEnum getSexByMessage(String message){
                for (SexEnum sexEnum: SexEnum.values()){
                    if (message.equals(sexEnum.getMessage())){
                        return sexEnum;
                    }
                }
                return null;
            }
    }

使用的时候，通过传入整数1和2，或者传入“男”、“女”，就可以创建一个性别实例。

本demo基于枚举类，将枚举类与mybatis相结合，数据库中存性别是存的1和2，但是视图层最终显示是需要显示“男”、“女”汉字信息的。
所以需要中间的转换，实现了视图层与数据库之间带有枚举类属性的用户的属性的转换。
具体过程以及注释在代码中，这里不做具体的介绍。

项目文件目录结构：

![项目文件结构](./src/main/resources/static/文件结构.PNG)

另外，这个demo只是为了简单学习枚举类与mybatis之间的转换而建。
个人觉得，在实际工程应用中，对性别的处理，其实完全用不到枚举类，后台直接用数字来表示就行了，
只是最后页面展示的时候，前端做一下简单的判断即可。枚举类可能更适用于数量稍微2个类别多一点的场景：如用户类别、季节等不超过10个类别的场景。