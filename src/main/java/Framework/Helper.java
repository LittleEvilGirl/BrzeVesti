package Framework;

public class Helper {
    
    public static int getRandomInt (){
        return (int) (Math.random() * 1000);
    }
    
    public static int getRandomIntRange (int range){
        return (int) (Math.random() * range);
    }
    
    public static String getRandomText(){
        return "Test-" + getRandomInt() ;
    }
    
    public static String getRandomEmail (){
        return getRandomText() + "@gmail.com";
    }
    
    public static String getRandomPassword (){
        return "password" + getRandomInt();
    }
    
    public static String getRandomTextTitle(){
        return "boba-" + getRandomInt() ;
    }
}
